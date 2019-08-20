package com.sld.commoncore.vo;

import lombok.Data;

import java.util.Map;

@Data
public class UserVo extends R {
    private Map<String, Object> user;

    public UserVo(boolean success) {
        this.setSuccess(success);
    }
}
