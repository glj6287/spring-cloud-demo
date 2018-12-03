package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@ApiModel
public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 4285331299496728953L;
    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("用户编码")
    private String userCode;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @NotNull(message = "用户姓名不能为空")
    @ApiModelProperty("用户姓名")
    private String userName;

    @ApiModelProperty("用户密码")
    private String userPwd;

    @NotNull(message = "部门编号不能为空")
    @ApiModelProperty("部门编号")
    private String orgCode;

    @ApiModelProperty("部门名称")
    private String orgName;

    @NotNull(message = "工号不能为空")
    @ApiModelProperty("工号")
    private String jobNum;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("微信openID")
    private String openId;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("状态(0:无效, 1:有效)")
    private String state;

    @ApiModelProperty("创建时间")
    private Date createTime; //创建时间

    @ApiModelProperty("创建人")
    private String creator; //创建人

    @ApiModelProperty("更新时间")
    private Date updateTime; //更新时间

    @ApiModelProperty("更新人")
    private String editor; //更新人

    @ApiModelProperty("版本号")
    private Long version; //版本号（解决并发处理，记录更新时+1）

    @ApiModelProperty("是否删除 0： 正常 1：已删除")
    private String deleted; //是否删除 0： 正常 1：已删除

    @ApiModelProperty("备注")
    private String remark; //备注

}