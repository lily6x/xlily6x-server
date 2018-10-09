package com.xlily6x.server.entity;


//import org.springframework.data.annotation.Id;

public class ServiceInfo {

//    @Id
    private String id;
    private String host;
    private Integer port;
    private Integer status;
    private String type;
    private String country;
    private String countryCode;
    private String division;
    private String divisionCode;
    private String isp;
    private Long createTime;// 注册时间
    private Long modifyTime;// 更新时间

    public ServiceInfo() {
        this.createTime = System.currentTimeMillis();
        this.modifyTime = System.currentTimeMillis();
        this.status = 1;
    }

    public ServiceInfo(String host, Integer port) {
        this.host = host;
        this.port = port;
        this.createTime = System.currentTimeMillis();
        this.modifyTime = System.currentTimeMillis();
        this.status = 1;
    }

    public ServiceInfo(String host, Integer port, String type, String country, String countryCode, String division, String divisionCode,String isp) {
        this.host = host;
        this.port = port;
        this.type = type;
        this.country = country;
        this.countryCode = countryCode;
        this.division = division;
        this.divisionCode = divisionCode;
        this.isp = isp;
        this.createTime = System.currentTimeMillis();
        this.modifyTime = System.currentTimeMillis();
        this.status = 1;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "id='" + id + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", status=" + status +
                ", type='" + type + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", division='" + division + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", isp='" + isp + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
