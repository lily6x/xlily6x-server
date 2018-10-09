package com.xlily6x.server.common;

import com.alibaba.fastjson.JSONObject;
import com.xlily6x.server.entity.IPInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: server
 * @description: IP 工具类
 * @author: xiaowenlong
 * @create: 2018-09-27
 **/
public class IPUtil {

    // 淘宝 IP 库 服务
    private static final String IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

    protected static final Log logger = LogFactory.getLog(IPUtil.class);

    // IPInfo 缓存集合
    protected static Map<String, IPInfo> IP_INFO_CACHE = new HashMap<>();

    
    /**
     * 获取IP信息
     * @param: [ip]
     * @return: java.util.Map<java.lang.String,java.lang.String>
     *     {"area":"","area_id":"","city":"XX","city_id":"xx","country":"香港","country_id":"HK","county":"XX",
     *     "county_id":"xx","ip":"202.53.138.30","isp":"XX","isp_id":"xx","region":"香港","region_id":"810000"}
     * @author: xiaowenlong
     * @date: 2018/9/27
     */
    public static IPInfo getIpInfo(String ip){
        IPInfo ic = IP_INFO_CACHE.get(ip);
        if(null!=ic){
            logger.info("Get IPInfo form cache : "+ip);
            return ic;
        }
        String url = IP_URL;
        String result = HttpClient.sendGet(url,"ip="+ip);
        JSONObject obj = JSONObject.parseObject(result);
        Object o = obj.get("data");
        IPInfo ipInfo = JSONObject.parseObject(o.toString(),IPInfo.class);
        IP_INFO_CACHE.put(ip,ipInfo);
        return ipInfo;
    }



}
