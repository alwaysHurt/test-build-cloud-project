package com.sld.upms.biz.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: ServiceMessageController
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:01
 */
@RestController
public class ServiceMessageController {

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/getPort")
    public String getPort(){
        return port;
    }

    @RequestMapping("/getName")
    public String getName(){
        return serverName;
    }

    @RequestMapping("/getServerMessage")
    public String getServerMessage(@RequestParam String message){
        return "Your message is "+message+"   服务名："+serverName+"  端口号："+port;
    }
}
