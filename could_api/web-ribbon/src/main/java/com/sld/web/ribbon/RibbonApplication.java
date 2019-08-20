package com.sld.web.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author admin
 * @Title: RibbonApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2022:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }
}
