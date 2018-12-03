package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author autoCode
 * @version 2017-11-16 11:03
 */
@Data
@ApiModel
public class RolePermissionDTO {

    @ApiModelProperty("关联角色的ID")
    private Long roleId;

    @ApiModelProperty("角色类型(查看0，修改1)")
    private Integer roleType;

    @ApiModelProperty("关联角色的系统菜单的IDS")
    private List<Long> sysMenuIds;

    @ApiModelProperty("关联角色的前段菜单的IDS")
    private List<Long> frontMenuIds;

    @ApiModelProperty("关联角色的主题菜单的ID")
    private List<Long> themeMenuIds;

}
