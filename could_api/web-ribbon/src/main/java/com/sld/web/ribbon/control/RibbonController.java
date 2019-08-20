package com.sld.web.ribbon.control;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.sld.web.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: RibbonController
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:15
 */
@RestController
@RequestMapping(value = "/ribbon")
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    /**测试熔断*/
    @RequestMapping(value = "/getServerMessage", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "reportError")
    public String getServerMessage(@RequestParam String message) {
        return ribbonService.getServerMessage(message);
    }


    String reportError(@RequestParam String message){
        return String.format("<h1>404</h1>  Hi your message is "+message+"  but request is failed !");
    }
}
