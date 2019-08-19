package com.sld.clouderuka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author admin
 * @Title: ErukaApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/199:21
 */
@SpringBootApplication
@EnableEurekaServer
public class ErukaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ErukaApplication.class,args);
    }
}
