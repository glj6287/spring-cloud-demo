package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author autoCode
 * @version 2017-11-03 08:57
 */
@Data
@ApiModel(description = "组织管理员")
public class OrgAdminDTO {

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("组织ID")
    @NotNull
    private Long orgId;

    @ApiModelProperty("管理员账号")
    @NotNull
    @Size(min = 4, max = 20)
    private String loginName;

    @ApiModelProperty("管理员密码")
    @NotNull
    @Size(min = 4, max = 20)
    private String password;

    @ApiModelProperty("管理员确认密码")
    @NotNull
    @Size(min = 4, max = 20)
    private String confirmPassword;

    private String userRemarks;

}
