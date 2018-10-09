package com.xlily6x.server.heartbeat;

import com.xlily6x.server.entity.ServiceInfo;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 *  服务工具类
 * @author: xiaowenlong
 * @date: 2018/9/26
 */
public class ServiceInfoUtil {

    //已注册服务集合
    private static final Map<String,ServiceInfo> serviceInfoMap = new HashMap<>();
    //返回结果 成功
    private static final String RESULT_SUCCESS = "success";
    //返回结果 失败
    private static final String RESULT_FAILURE = "failure";

    
    /**
     * 服务注册
     * @param: [serviceInfo]
     * @return: java.lang.String
     * @author: xiaowenlong
     * @date: 2018/9/26
     */ 
    public static String register(ServiceInfo serviceInfo){
        if(null==serviceInfo) return RESULT_FAILURE;
        //1. 新增一行记录
        String key = serviceInfo.getHost()+":"+serviceInfo.getPort();
        serviceInfoMap.put(key,serviceInfo);
        return RESULT_SUCCESS;
    }

    /**
     * 服务销毁
     * @param: [serviceInfo]
     * @return: java.lang.String
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public static String destroy(ServiceInfo serviceInfo){
        if(null==serviceInfo) return RESULT_FAILURE;
        String key = serviceInfo.getHost()+":"+serviceInfo.getPort();
        serviceInfoMap.remove(key);
        return RESULT_SUCCESS;
    }

    /**
     * 获取所有已注册的服务信息
     * @param: []
     * @return: java.util.List<com.xlily6x.server.entity.ServiceInfo>
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public static List<ServiceInfo> getServiceInfoList() {
        return getServiceInfoList(null);
    }

    /**
     * 根据服务类型获取所有服务信息
     * @param: [type] 服务类型（由服务提供方指定）
     * @return: java.util.List<com.xlily6x.server.entity.ServiceInfo>
     * @author: xiaowenlong
     * @date: 2018/9/27
     */ 
    public static List<ServiceInfo> getServiceInfoList(String type){
        List<ServiceInfo> list = new ArrayList<>();
        for(String key:serviceInfoMap.keySet()){
            if(StringUtils.isEmpty(type)){
                list.add(serviceInfoMap.get(key));
            }else{
                if(serviceInfoMap.get(key).getType().equals(type)){
                    list.add(serviceInfoMap.get(key));
                }
            }
        }
        return list;
    }
}
