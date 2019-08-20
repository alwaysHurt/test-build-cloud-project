package com.sld.commoncore.vo;


import com.sld.commoncore.constant.enums.ResultCodeEnum;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * websocket响应信息主体
 *
 * @param <T>
 * @author jurendada
 */
@Builder
@ToString
@Accessors(chain = true)
@AllArgsConstructor
public class Rws<T> implements Serializable {

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
    private T data;

    @Getter
    @Setter
    @Builder.Default
    private LocalDateTime lastTime = LocalDateTime.now();

    @Getter
    @Setter
    private String type = null;    // websocket消息类型事件

    public Rws() {
        super();
    }


    /**
     * 数据、消息
     *
     * @param data
     */
    public Rws(T data) {
        super();
        if (data instanceof Boolean) {
            this.success = (Boolean) data;
            this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        } else {
            this.data = data;
        }
    }

    /**
     * 数据、事件类型
     *
     * @param data
     * @param type
     */
    public Rws(T data, String type) {
        super();
        if (data instanceof Boolean) {
            this.success = (Boolean) data;
            this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        } else {
            this.data = data;
        }
        this.type = type;
    }

    /**
     * 异常
     *
     * @param e
     */
    public Rws(Throwable e) {
        super();
        this.data = (T)e.getMessage();
        this.code = ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.success = false;
    }

    /**
     * 处理结果
     *
     * @param success
     */
    public Rws(Boolean success) {
        super();
        this.success = success;
        this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
    }

    /**
     * 处理结果、事件类型
     *
     * @param success
     * @param type
     */
    public Rws(Boolean success, String type) {
        super();
        this.success = success;
        this.code = this.success ? ResultCodeEnum.DEFAULT_SUCCESS.getCode() : ResultCodeEnum.DEFAULT_FAILURE.getCode();
        this.type = type;
    }

}
