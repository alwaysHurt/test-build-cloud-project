package com.sld.upms.biz;

/**
 * @author admin
 * @Title: BizApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1920:26
 */

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

/**
 * @author admin
 * @Title: UpmsApplication
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/199:37
 */
@SpringBootApplication(scanBasePackages = {"com.sld"})
//eruka客户端
@EnableEurekaClient
//发现客户端
@EnableDiscoveryClient
//开启定时任务注解
//@EnableScheduling
//开启feign
//@EnableFeignClients(basePackages = {"com.ingsys.plm.upms.api.feign","com.ingsys.plm.fdfs.api.feign"})
@EntityScan("")
//开启事务
@EnableTransactionManagement
public class BizApplication {
    public static void main(String[] args) {
        SpringApplication.run(BizApplication.class,args);
    }

    @Bean
    @Autowired
    public JPAQueryFactory jpaQuery(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

    @Slf4j
    @RestController
    static class TestController {

        @GetMapping("/hello")
        public String hello() {
            return "didispace.com";
        }

    }
}
