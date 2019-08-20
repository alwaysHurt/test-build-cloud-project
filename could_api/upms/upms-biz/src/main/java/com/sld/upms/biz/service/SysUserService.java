package com.sld.upms.biz.service;

import com.querydsl.core.QueryResults;
import com.sld.upms.api.entity.SysUser;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @Title: SysUserService
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1914:09
 */
public interface SysUserService {
    /**
     * 单个删除
     */
    void delete(String userId);

    /**
     * 删除多个
     * @param userIds
     */
    void delete(String[] userIds);

    /**
     * 增加
     */
    void insert(SysUser sysUser);

    /**
     * 更新
     */
    int update(SysUser sysUser);

    /**
     * 查询单个
     */
    SysUser selectById(String userId);

    /**
     * 用户编号查询单个
     **/
    SysUser findOneByUserNo(String userNo);

    /**
     * 保存用户列表
     *
     * @param sysUsers
     */
    void saveAll(List<SysUser> sysUsers);

    /**
     * 前端分页查询所有的实体
     *
     * @return
     */
    QueryResults<SysUser> query(Pageable pageable, Map<String, Object> params);




    /**
     * 根据姓名查询用户
     *
     * @param filter
     * @return
     */
    List<SysUser> findByUserName(String filter);
}
