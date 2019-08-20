package com.sld.upms.biz.service.impl;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.sld.upms.api.entity.QSysUser;
import com.sld.upms.api.entity.SysUser;
import com.sld.upms.biz.dao.SysUserRepo;
import com.sld.upms.biz.service.CommonQueryService;
import com.sld.upms.biz.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author admin
 * @Title: SysUserServiceImpl
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1917:23
 */
@Service
@Slf4j
public class SysUserServiceImpl  implements SysUserService {
    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    CommonQueryService commonQueryService;

    @Autowired
    private SysUserRepo repository;


    @Resource
    private SysUserRepo sysUserRepo;

    public SysUserServiceImpl() {
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insert(SysUser sysUser) {
        repository.save(sysUser);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(String userId) {
        repository.deleteById(userId);
    }

    /**
     * 删除多个
     *
     * @param userIds
     */
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(String[] userIds) {
        for (String userId : userIds) {
            repository.deleteById(userId);
        }
    }


    @Override
//    @CacheEvict(value = "sysUserCache",key = "#sysUser.userNo")
    @Transactional(rollbackFor = {Exception.class})
    public int update(SysUser sysUser) {
        repository.save(sysUser);
        return 1;
    }

    @Override
    public SysUser selectById(String userId) {
        Optional<SysUser> optional = repository.findById(userId);
        SysUser sysUser = optional.get();
        return sysUser;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveAll(List<SysUser> sysUsers) {
        repository.saveAll(sysUsers);
    }

    /**
     * 前端分页查询所有的实体
     *
     * @param pageable
     * @param params
     * @return
     */
    @Override
    public QueryResults<SysUser> query(Pageable pageable, Map<String, Object> params) {
        QSysUser qSysUser = QSysUser.sysUser;
        JPAQuery<SysUser> jpaSysUser = (JPAQuery<SysUser>) commonQueryService.queryBase(qSysUser, pageable, params);
        return jpaSysUser.fetchResults();
    }


    /**
     * 用户编号查询单个
     * 并缓存
     **/
    @Override
//    @Cacheable(cacheNames = "sysUserCache", key = "#userNo")
    public SysUser findOneByUserNo(String userNo) {
        SysUser sysUser = repository.findOneByUserNo(userNo);
        return sysUser;
    }


    /**
     * 根据姓名查询用户用户
     *
     * @param filter
     * @return
     */
    @Override
    public List<SysUser> findByUserName(String filter) {
        return sysUserRepo.findUsersLikeUsername(filter);
    }
}
