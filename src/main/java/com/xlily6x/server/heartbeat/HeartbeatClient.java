package com.xlily6x.server.heartbeat;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HeartbeatClient {
    protected static final int SERVER_PORT = 61378;
    protected static final int CLIENT_PORT = 60278;
    protected static final int RECEIVE_LENGTH = 1024;
    protected static final String SERVER_HOST = "127.0.0.1";


//    public static void init(int port,String msg) throws Exception{
//        byte [] data = msg.getBytes();
//        DatagramSocket socket = new DatagramSocket(port);
//        DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName(SERVER_HOST),SERVER_PORT);
//        socket.send(packet);
//        socket.close();
//    }
//
//    @Test
//    public void testc1() throws Exception{
//        HeartbeatClient.init(60278,"tigase");
//        HeartbeatClient.init(60279,"tigase");
//        HeartbeatClient.init(60280,"service");
//        HeartbeatClient.init(60281,"service");
//    }
//
//    @Test
//    public void test3(){
//        String s = " --service.types=tigase";
//        System.out.println(s);
//        String e = s.trim().substring(2,s.indexOf("=")-1);
//        String e2 = s.trim().substring(s.indexOf("="),s.length()-1);
//        System.out.println(e);
//        System.out.println(e2);
//
//        String d = "8080,service";
//        String l = d.substring(d.indexOf(",")+1,d.length());
//        System.out.println(l);
//
//        String q = d.substring(0,d.indexOf(","));
//        System.out.println(q);
//    }

}
