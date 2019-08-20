package com.sld.commoncore.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 树形控件类
 * @author jurendada
 */
@Data
@Builder
public class TreeNode<T> {
    private String title;
    private String key;
    private String icon;
    private List<TreeNode> children;
    private boolean isLeaf;
    private boolean checked;
    private boolean selected;
    private boolean expanded;
    private boolean selectable;
    private boolean disabled;
    private boolean disableCheckbox;
    private T data;

}
