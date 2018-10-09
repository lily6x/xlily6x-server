package com.xlily6x.server;

import com.xlily6x.server.heartbeat.HeartbeatProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Xlily6xServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Xlily6xServerApplication.class, args);
        new Thread(() -> HeartbeatProcessing.init() ).start();
    }
}
