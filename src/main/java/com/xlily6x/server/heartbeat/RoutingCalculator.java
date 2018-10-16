package com.xlily6x.server.heartbeat;

import com.xlily6x.server.common.IPUtil;
import com.xlily6x.server.entity.IPInfo;
import com.xlily6x.server.entity.ServiceInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: server
 * @description: 路由算法程序
 * @author: xiaowenlong
 * @create: 2018-09-27
 **/
public class RoutingCalculator {
    
    /**
     * 选择最佳服务器
     * @param: [ip, serviceInfoList]
     * @return: com.xlily6x.server.entity.ServiceInfo
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public static ServiceInfo chooseTheBestService(String ip, List<ServiceInfo> serviceInfoList){
        List<ServiceInfo> rs = new ArrayList<>();
        ServiceInfo res = new ServiceInfo();
        IPInfo ipInfo = IPUtil.getIpInfo(ip);
        for(ServiceInfo i : serviceInfoList){
            if(i.getCountryCode().equals(ipInfo.getCountry_id())){
                rs.add(i);
            }
        }
        if(rs.size()>0){
            int s =getRandom(0,rs.size());
            res = rs.get(s);
        }
        return res;
    }

    public static int getRandom(int min, int max){
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;

    }
}
