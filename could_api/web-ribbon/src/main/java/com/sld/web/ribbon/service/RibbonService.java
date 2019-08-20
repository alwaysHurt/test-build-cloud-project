package com.sld.web.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 * @Title: ServerService
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/2023:10
 */
@Service
public class RibbonService {

    @Autowired
    RestTemplate restTemplate;

    public String getServerMessage(String message) {
        return restTemplate.getForObject("http://UPMS-BIZ/getServerMessage?message="+message , String.class);
    }
}
