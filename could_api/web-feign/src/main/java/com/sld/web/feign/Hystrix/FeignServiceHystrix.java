package com.sld.web.feign.Hystrix;

import com.sld.web.feign.service.FeignService;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @Title: FeignServiceHystrix
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/217:17
 */
@Component
public class FeignServiceHystrix implements FeignService {
    @Override
    public String getServerMessage(String message) {
        return "<h1>404</h1> Hi，your message is :\"" + message + "\" but request error.";
    }
}
