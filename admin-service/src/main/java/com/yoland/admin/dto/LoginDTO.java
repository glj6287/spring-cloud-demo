package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@ApiModel(description = "用户登录请求参数")
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = 5069353664786384066L;
    @ApiModelProperty("用户登录账号")
    @NotNull(message = "用户名不能为空")
    @Size(min = 4, max = 20, message = "用户名必须在4到20位字符之间")
    private String jobNum;

    @ApiModelProperty("用户登录密码")
    @NotNull(message = "密码不能为空")
    @Size(min = 4, max = 20, message = "密码必须在4到20位字符之间")
    private String userPwd;

}
