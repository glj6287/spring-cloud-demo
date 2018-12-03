package com.yoland.admin.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author glj
 *
 */
@Data
@ApiModel
public class UpdatePwdDTO implements Serializable {

	private static final long serialVersionUID = 6727507965044682559L;

	@NotNull
	@Size(min = 4, max = 20, message = "密码必须在4到20位字符之间")
	@ApiModelProperty("原密码")
	private String oldPwd;
	
    @NotNull
    @Size(min = 4, max = 20, message = "密码必须在4到20位字符之间")
	@ApiModelProperty("新密码")
	private String newPwd;

}
