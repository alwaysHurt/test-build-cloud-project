package com.sld.web.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author admin
 * @Title: FeignApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:39
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sld.web.feign.service")
@EnableHystrixDashboard
public class FeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}
