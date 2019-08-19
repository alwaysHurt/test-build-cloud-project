package com.sld.upms.biz.service.impl;

import com.querydsl.core.support.QueryBase;
import com.querydsl.core.types.dsl.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sld.upms.biz.service.CommonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Query;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author admin
 * @Title: CommonQueryServiceImpl
 * @ProjectName test-build-cloud-project
 * @Description: TODO
 * @date 2019/8/1917:45
 */
@Service
public class CommonQueryServiceImpl implements CommonQueryService {

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    EntityManager entityManager;

    @Override
    public QueryBase queryBase(EntityPathBase qEntity, Pageable pageable, Map<String, Object> params) {
        QueryBase queryBase = queryFactory.selectFrom(qEntity);
        try {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if ("sort".equals(entry.getKey()) && entry.getValue() != null) {
                    Map<String, String> map = (Map<String, String>) entry.getValue();
                    Field field = qEntity.getClass().getField(map.get("orderField"));
                    Object obj = field.get(qEntity);
                    ComparableExpressionBase ceb = (ComparableExpressionBase) obj;
                    if ("descend".equals(map.get("order"))) {
                        queryBase.orderBy(ceb.desc());
                    } else {
                        queryBase.orderBy(ceb.asc());
                    }
                } else {
                    Field field = qEntity.getClass().getField(entry.getKey());
                    Object obj = field.get(qEntity);
                    if (obj instanceof StringPath) {
                        StringPath sp = (StringPath) obj;
                        if(entry.getValue() == null){
                            queryBase.where(sp.contains("").or(sp.isEmpty().or(sp.isNull())));
                        } else {
                            queryBase.where(sp.contains((String) entry.getValue()));
                        }
                    } else if (obj instanceof DateTimePath || obj instanceof DatePath) {
                        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        List<String> timesStr = (List<String>) entry.getValue();
                        DateTimePath dp = (DateTimePath) obj;
                        queryBase.where(dp.between(LocalDateTime.parse(timesStr.get(0), df) , LocalDateTime.parse(timesStr.get(1), df)));
                    } else if (obj instanceof NumberPath) {
                        NumberPath np = (NumberPath) obj;
                        queryBase.where(np.eq(entry.getValue()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        queryBase.offset(pageable.getOffset()).limit(pageable.getPageSize());  //每页大小
        return queryBase;
    }


    @Override
    public boolean noRepeat(Object object) {

        // 实体类获取className
        String className = object.getClass().getSimpleName();

        // 根据className查防重配置表获取信息
        String sql = "select field_name from plm_no_recheck where plm_no_recheck.entity_name = '" + className + "'";
        String fields = (String) entityManager.createNativeQuery(sql).getSingleResult();

        String where = "";

        // 判断防重字段情况
        if (fields.contains("(")) {

            fields = fields.substring(fields.indexOf("(")+1, fields.indexOf(")"));

            // 从信息获取相关字段，并根据相关字段获取实体的属性值
            String[] fieldNames = fields.split("\\,");

            // 值分别不相等
            for (String fieldName : fieldNames) {
                where += fieldName + " = " + getFieldValueByName(fieldName, object) + " or ";
            }
            where = where.substring(0, where.length() - 3);
        } else {
            // 从信息获取相关字段，并根据相关字段获取实体的属性值
            String[] fieldNames = fields.split("\\,");

            // 值同时不相等
            for (String fieldName : fieldNames) {
                where += fieldName + " = " + getFieldValueByName(fieldName, object) + " and ";
            }
            where = where.substring(0, where.length() - 4);
        }

        // 查询实体对应的表判断防重
        String hql = "from " + className + " where " + where;
        Query query = entityManager.createQuery(hql);
        List<Object> list = query.getResultList();

        if (list.isEmpty()) {
            return false;
        }

        String oId = getIdFiled(object);
        String oIdValue = (String) getFieldValueByName(oId, object);

        // 修改
        if (oIdValue != null) {
            // 判断查询到的数据是否是要修改的数据本身
            String queryId = null;
            for (Object o : list) {
                queryId = (String) getFieldValueByName(oId, o);
            }
            if (queryId.equals(oIdValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据属性名称获取对应的值
     *
     * @param fieldName
     * @param o
     * @return
     */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value = method.invoke(o, new Object[]{});
            return value;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取对象的Id属性名
     */
    private String getIdFiled(Object object) {
        return Stream.of(object.getClass().getDeclaredFields()).filter(field -> {
            for (Annotation annotation : field.getDeclaredAnnotations()) {
                if (annotation.annotationType().getClass().isInstance(Id.class)) {
                    return true;
                }
            }
            return false;
        }).findFirst().get().getName();
    }
}
