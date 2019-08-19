package com.sld.upms.biz.service;

import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author admin
 * @Title: CommonQueryService
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1917:43
 */
public interface CommonQueryService {
    /**
     * @param qEntity  Querydsl 查询实体
     * @param pageable 分页信息
     * @param params   前端参数
     * @return
     */
    QueryBase queryBase(EntityPathBase qEntity, Pageable pageable, Map<String, Object> params);

    /**
     * 判断字段值是否重复，重复返回true
     * @param object 实体对象
     * @return
     */
    boolean noRepeat(Object object);
}
