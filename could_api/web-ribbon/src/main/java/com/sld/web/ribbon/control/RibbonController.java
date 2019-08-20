package com.sld.web.ribbon.control;

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

    @RequestMapping(value = "/getServerMessage", method = RequestMethod.GET)
    public String getServerMessage(@RequestParam String message) {
        return ribbonService.getServerMessage(message);
    }
}
