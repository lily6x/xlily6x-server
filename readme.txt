服务注册中心
初始化版本 1.0.0-SNAPSHOT

1. 心跳服务监听
    服务提供者与服务主机的主要联系渠道。
2. 服务注册
    客户端可通过注册服务，添加到本系统中，添加到系统中的服务可被客户端发现。
3. 获取IP所在位置信息
    系统会根据客户端请求的IP地址所在位置，经过特定的算法，给出最佳服务提供者地址。
4. 服务检测机制
    系统会周期性检测服务的可用性，当服务提供者拒绝提供服务后，系统会将其剔除，客户端在获取服务时将获取不到该服务。
5. 服务查询Rest接口
    可通过 http://ip:port/system/main 接口获取最佳服务提供者信息
    参数： String ip  请求IP
    参数： String [] types  服务类型