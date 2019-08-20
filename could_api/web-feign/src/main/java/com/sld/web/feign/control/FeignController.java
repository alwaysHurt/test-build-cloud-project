package com.sld.web.feign.control;

import com.sld.web.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @Title: FeignController
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:50
 */
@RestController
@RequestMapping(value = "/feign")
public class FeignController {
    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "/getServerMessage", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return feignService.getServerMessage(message);
    }
}
