package com.yoland.admin.dto;

import com.yoland.common.entity.original.SysOrgan;
import com.yoland.common.entity.original.SysRole;
import com.yoland.common.entity.original.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * LoginVO
 */
@Data
@ApiModel(value = "LoginUser", description = "用户登录响应")
public class LoginVO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("组织实体类")
    private SysOrgan sysOrgan;

    @ApiModelProperty("用户实体类")
    private SysUser sysUser;

    @ApiModelProperty("用户角色实体类")
    private SysRole sysRole;

    @ApiModelProperty("用户Token")
    private String token;

    @ApiModelProperty("刷新Token，用于刷新已经过期的token")
    private String refreshToken;

}
