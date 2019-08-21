package com.sld.upms.biz.control;

import com.querydsl.core.QueryResults;
import com.sld.commoncore.vo.R;
import com.sld.upms.api.entity.SysUser;
import com.sld.upms.biz.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @Title: SysUserController
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1910:41
 */
@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/get",method = RequestMethod.GET )
    public R get(String userId) {
        return new R(sysUserService.selectById(userId));
    }

    @PostMapping("/add")
    public R add(@RequestBody SysUser sysUser) {
        sysUser.setPassword("$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC");
        sysUser.setCreateTime(LocalDateTime.now());
        sysUserService.insert(sysUser);
        return new R(true, "新增用户成功!");
    }

    @PostMapping("/delete")
    public R delete(@RequestBody String[] userIds) {
        sysUserService.delete(userIds);
        return new R(true, "删除用户成功!");
    }

    @PostMapping("/update")
    public R update(@RequestBody SysUser sysUser) {
        sysUser.setUpdateTime(LocalDateTime.now());
        sysUser.setPassword("$2a$10$RpFJjxYiXdEsAGnWp/8fsOetMuOON96Ntk/Ym2M/RKRyU0GZseaDC");
        sysUserService.update(sysUser);
        return new R(true, "修改用户成功!");
    }

    @PostMapping("/query")
    public R query(Integer pi, Integer ps, Map<String, Map<String, String>> sort, @RequestBody Map<String, Object> params) {
        Pageable pageable = PageRequest.of(pi - 1 < 0 ? 0 : pi - 1, ps);
        QueryResults<SysUser> results = sysUserService.query(pageable, params);
        List<SysUser> users = results.getResults();
        return new R(users).setTotal(results.getTotal());
    }




}
