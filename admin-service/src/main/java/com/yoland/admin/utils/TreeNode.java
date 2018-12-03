package com.yoland.admin.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树形查询结果单个节点对象
 * @author autoCode
 * @version 2017-10-30 10:45
 */
@Data
@ApiModel
public class TreeNode<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    @ApiModelProperty
    private Long id;

    /**
     * 节点名称
     */
    @ApiModelProperty
    private String name;

    /**
     * 父节点ID
     */
    @ApiModelProperty
    private Long parentId;

    /**
     * 节点数据(节点包含的具体对象的数据)
     */
    @ApiModelProperty
    private T data;

    /**
     * 子节点数据
     */
    @ApiModelProperty
    private List<TreeNode<T>> children;

    public TreeNode() {

    }

    public TreeNode(long id, String name, long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public void addChild(TreeNode<T> childTreeNode) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }

        this.children.add(childTreeNode);
    }

}