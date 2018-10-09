package com.xlily6x.server.heartbeat;

import com.xlily6x.server.entity.ServiceInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: server
 * @description: 服务检测定时器
 * @author: xiaowenlong
 * @create: 2018-09-26 19:36
 **/
@Component
@EnableScheduling
public class TimerTask {

    protected static final Log logger = LogFactory.getLog(TimerTask.class);
    /**
     * 定时任务， 检查 ServiceInfo 信息
     * 每一分钟检查一次 ， fixedRate 单位 毫秒
     * @param: []
     * @return: void
     * @author: xiaowenlong
     * @date: 2018/9/26
     */ 
    @Scheduled(fixedRate = 1000*60*1)
    public void checkServiceInfo(){
        logger.info("Check ServiceInfo ");
        List<ServiceInfo> list = ServiceInfoUtil.getServiceInfoList();
        logger.info("Total number of current services : "+list.size());
        logger.info(list);
        int count = 0;
        if(list.size()>0){
            long l = 0;
            for(ServiceInfo s : list){
                l = System.currentTimeMillis();
                //若连接时间大于一分钟视为该服务已停止提供服务
                if(l-s.getModifyTime()>1000*1*60*1){
                    ServiceInfoUtil.destroy(s);
                    count++;
                    logger.warn("The service is offline : "+s);
                }
            }
        }
        list = ServiceInfoUtil.getServiceInfoList();
        logger.info(count + " service destroyed ");
        logger.info("After checking Total number of current services : "+list.size());
        logger.info(list);
    }

}
