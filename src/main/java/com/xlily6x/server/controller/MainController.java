package com.xlily6x.server.controller;

import com.xlily6x.server.service.ServiceInfoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/system")
public class MainController {

    protected static final Log logger = LogFactory.getLog(MainController.class);


    @Autowired
    ServiceInfoService serviceInfoService;


    @RequestMapping(value = "/main")
    public String main(String ip,String [] types){
        return serviceInfoService.getServiceInfo(ip,types);
    }


}
