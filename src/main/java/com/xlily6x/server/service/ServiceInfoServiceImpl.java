package com.xlily6x.server.service;

import com.alibaba.fastjson.JSONObject;
import com.xlily6x.server.entity.ServiceInfo;
import com.xlily6x.server.heartbeat.RoutingCalculator;
import com.xlily6x.server.heartbeat.ServiceInfoUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: server
 * @description: 服务信息处理实现
 * @author: xiaowenlong
 * @create: 2018-09-27
 **/
@Service
public class ServiceInfoServiceImpl implements ServiceInfoService{

    protected static final Log logger = LogFactory.getLog(ServiceInfoService.class);

//    @Autowired
//    ServiceRepository repository;
//
//    @Autowired
//    MongoTemplate template;


    @Override
    public String getServiceInfo(String ip,String ... types) {
        Map<String,ServiceInfo> result = new HashMap<>();
        for(String type : types){
            List<ServiceInfo> list = ServiceInfoUtil.getServiceInfoList(type);
            ServiceInfo serviceInfo = chooseTheBestService(ip,list);
            result.put(type,serviceInfo);
        }
        return JSONObject.toJSONString(result);
    }

    private ServiceInfo chooseTheBestService(String ip,List<ServiceInfo> serviceInfoList){
        return RoutingCalculator.chooseTheBestService(ip,serviceInfoList);
    }


//    /**
//     * 从DB中读取数据
//     * @param: []
//     * @return: java.lang.String
//     * @author: xiaowenlong
//     * @date: 2018/9/27
//     */
//    private String readDB(){
//        logger.info("main controller executed !");
//        ServiceInfo serviceInfo = new ServiceInfo();
//        serviceInfo.setHost("192.168.2.140");
//        repository.insert(serviceInfo);
//
//        Criteria criteria = new Criteria();
//        criteria.and("status").equals("1");
//        Query query = new Query(criteria);
//
//        Query query1 = Query.query(Criteria.where("status").is("1"));
//
//        List<ServiceInfo> list1 = template.find(query1,ServiceInfo.class);
//
//        String s = JSONObject.toJSONString(template.findOne(new Query(criteria),ServiceInfo.class));
//        logger.info(s);
//        List<ServiceInfo> list = template.findAll(ServiceInfo.class);
//        logger.info(list);
//
//        logger.info(list1);
//
//        return JSONObject.toJSONString(list);
//    }
}
