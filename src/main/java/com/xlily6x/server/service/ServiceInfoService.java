package com.xlily6x.server.service;

import org.springframework.stereotype.Service;

/**
 * @program: server
 * @description: 服务信息处理
 * @author: xiaowenlong
 * @create: 2018-09-27
 **/
@Service
public interface ServiceInfoService {

    /**
     * 获取服务信息
     * @param: []
     * @return: java.lang.String
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public String getServiceInfo(String ip,String ... type);
}
