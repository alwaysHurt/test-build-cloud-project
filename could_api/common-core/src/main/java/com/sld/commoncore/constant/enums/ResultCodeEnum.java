package com.sld.commoncore.constant.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 定义plm系统公用的返回值和异常信息的对应关系
 * 方便全局统一处理异常,方便接口返回信息
 *
 * @author xutong
 */
@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    /**
     * 默认的成功返回
     */
    DEFAULT_SUCCESS(1, null, "操作成功"),
    /**
     * 默认失败返回
     */
    DEFAULT_FAILURE(0, Exception.class, "操作失败")
    // TODO 补充其它系统返回值
    ;

    /**
     * 返回值的返回码
     */
    private Integer code;
    /**
     * 返回码对应的异常类型
     */
    private Class eClazz;
    /**
     * 返回码对应的默认返回消息
     */
    private String message;


}
