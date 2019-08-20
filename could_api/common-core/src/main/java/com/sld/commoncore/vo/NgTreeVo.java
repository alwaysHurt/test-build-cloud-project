package com.sld.commoncore.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Auther: jurendada
 * @Date: 2019/7/2 17:23
 * @Description: ng-zorro 的树形控件 vo
 */

@Builder
@Data
public class NgTreeVo {

    private String codeType;
    private String value;
    private String label;
    private Boolean isLeaf;
    private List<NgTreeVo> children;
}
