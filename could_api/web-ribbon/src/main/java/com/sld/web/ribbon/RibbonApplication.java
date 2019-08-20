package com.sld.web.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author admin
 * @Title: RibbonApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2022:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
    }
}
