package com.sld.commoncore.vo;


import com.sld.commoncore.constant.enums.ResultCodeEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * http响应信息主体
 *
 * @param <T>
 * @author jurendada
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = -3378584903946455561L;
    @Getter
    @Setter
    @Builder.Default
    private Integer code = ResultCodeEnum.DEFAULT_SUCCESS.getCode();

    @Getter
    @Setter
    @Builder.Default
    private Boolean success = true;

    @Getter
    @Setter
    @Builder.Default
    private String message = ResultCodeEnum.DEFAULT_SUCCESS.getMessage();


    @Getter
    @Setter
    private T data;

    @Getter
    @Setter
    @Builder.Default
    private LocalDateTime lastTime = LocalDateTime.now();

    @Getter
    @Setter
    @Builder.Default
    private String url = "";

    @Getter
    @Setter
    private Long total = 0l;

    public R() {
        super();
    }

    public R(T data) {
        super();
        this.data = data;
    }

    /**
     * 数据、消息
     *
     * @param data
     * @param message
     */
    public R(T data, String message) {
        super();
        if (data instanceof Boolean) {
            this.success = (Boolean) data;
            this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        } else {
            this.data = data;
        }
        this.message = message;
    }

    /**
     * 数据、消息、url
     *
     * @param data
     * @param message
     * @param url
     */
    public R(T data, String message, String url) {
        super();
        if (data instanceof Boolean) {
            this.success = (Boolean) data;
            this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        } else {
            this.data = data;
        }
        this.message = message;
        this.url = url;
    }

    /**
     * 异常
     *
     * @param e
     */
    public R(Throwable e) {
        super();
        this.message = e.getMessage();
        this.code = ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.success = false;
    }

    /**
     * 处理结果
     *
     * @param success
     */
    public R(Boolean success) {
        super();
        this.success = success;
        this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.message = success ? ResultCodeEnum.DEFAULT_SUCCESS.getMessage() : ResultCodeEnum.DEFAULT_FAILURE.getMessage();
    }

    /**
     * 处理结果、消息
     *
     * @param success
     * @param message
     */
    public R(Boolean success, String message) {
        super();
        this.success = success;
        this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.message = message;
    }

    /**
     * 处理结果、消息、url
     *
     * @param success
     * @param message
     * @param url
     */
    public R(Boolean success, String message, String url) {
        super();
        this.success = success;
        this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.message = message;
        this.url = url;
    }

}
