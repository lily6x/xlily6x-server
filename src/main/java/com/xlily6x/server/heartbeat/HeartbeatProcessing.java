package com.xlily6x.server.heartbeat;

import com.xlily6x.server.common.IPUtil;
import com.xlily6x.server.entity.IPInfo;
import com.xlily6x.server.entity.ServiceInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 心跳处理
 * @author xiaowenlong
 * @Date 2018/09/26
 */
public class HeartbeatProcessing {

    protected static final Log logger = LogFactory.getLog(HeartbeatProcessing.class);
    //服务端口
    protected static final int SERVER_PORT = 61378;
    //读取byte大小
    protected static final int RECEIVE_LENGTH = 1024;

    /**
     * 心跳处理程序初始化
     * @param: []
     * @return: void
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public static void init(){

        try {
            logger.info("Heartbeat service start");
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);
            byte [] data = new byte[RECEIVE_LENGTH];
            DatagramPacket packet = new DatagramPacket(data,data.length);
            boolean f = true;
            while (f){
                socket.receive(packet);
                InetAddress inetAddress = packet.getAddress();
                int cport = packet.getPort();

                String msg = new String(data,0,packet.getLength());

                String msgs [] = msg.split(",");
                String type = msgs[0];
                String host = msgs[1];
                String port = msgs[2];
                IPInfo ipInfo = null;
                try {
                    ipInfo = IPUtil.getIpInfo(host);
                } catch (Exception e) {
                    logger.error("Get IP Info failure");
                    logger.error(e.getMessage());
                }
                if(null != ipInfo){
                    logger.info(ipInfo);
                    //服务注册
                    ServiceInfoUtil.register(new ServiceInfo(host,Integer.parseInt(port),type,ipInfo.getCountry(),ipInfo.getCountry_id(),ipInfo.getRegion(),ipInfo.getRegion_id(),ipInfo.getIsp()));
                    logger.info("Server received data from client  : "+inetAddress.getHostAddress()+":"+cport + "  body :  "+msg);
                }
            }
            socket.close();

        } catch (SocketException e) {
            logger.error("Connect server exception");
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error("Send message exception");
            logger.error(e.getMessage());
        }
    }

}
