package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author autoCode
 * @version 2017-10-31 14:00
 */
@Data
@ApiModel
public class SysMenuVO {

    /**
     * id
     */
    @ApiModelProperty("逻辑主键")
    private Long id;

    /**
     * 父级编号
     */
    @ApiModelProperty("父级编号")
    private Long parentId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 菜单链接
     */
    @ApiModelProperty("菜单链接")
    private String path;

    /**
     * 菜单组件
     */
    @ApiModelProperty("菜单组件")
    private String component;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String iconCls;

    /**
     * 是否为叶子节点，即没有子菜单
     */
    @ApiModelProperty("是否为叶子节点，即没有子菜单")
    private Boolean leaf;

    /**
     * 子菜单
     */
    @ApiModelProperty("子菜单")
    private List<SysMenuVO> children;

}