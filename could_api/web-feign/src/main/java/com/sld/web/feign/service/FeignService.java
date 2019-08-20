package com.sld.web.feign.service;

import com.sld.web.feign.Hystrix.FeignServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author admin
 * @Title: FeignService
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:46
 */
@FeignClient(value = "upms-biz" ,fallback = FeignServiceHystrix.class)
public interface FeignService {

    @RequestMapping(value = "/getServerMessage", method = RequestMethod.GET)
     String getServerMessage(@RequestParam String message);
}
