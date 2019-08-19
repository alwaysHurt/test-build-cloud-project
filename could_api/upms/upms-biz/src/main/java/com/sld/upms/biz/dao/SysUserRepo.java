package com.sld.upms.biz.dao;


import com.sld.upms.api.entity.SysUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author admin
 * @Title: SysUserRepo
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1910:46
 */
@Repository
public interface SysUserRepo extends JpaRepository<SysUser, String>, JpaSpecificationExecutor<SysUser> {

    SysUser findOneByUserNo(String userNo);

    List<SysUser> findAllByUserNoAndUserName(String userNo, String userName, Pageable pageable);

    @Query(nativeQuery = true, value = "select * from sys_user  where user_name like %:username%")
    List<SysUser> findUsersLikeUsername(@Param("username") String username);
}
