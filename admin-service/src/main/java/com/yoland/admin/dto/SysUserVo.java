package com.yoland.admin.dto;

import com.yoland.common.entity.original.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author guanlijun
 * @Date 2018/6/3 16:54
 */
@Data
@ApiModel(description = "用户分页实体")
public class SysUserVo extends Page implements Serializable {

    private static final long serialVersionUID = -3939049935908670336L;

    @ApiModelProperty("用户编码")
    private String userCode;

    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("工号")
    private String jobNum;

    @ApiModelProperty("状态(0:无效, 1:有效)")
    private String state;

    @ApiModelProperty("部门编号")
    private String orgCode;

    @ApiModelProperty("部门名称")
    private String orgName;

}
