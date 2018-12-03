package com.yoland.common.entity.original;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
@TableName("t_sys_user")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysUser extends Model<SysUser> {
    private static final long serialVersionUID = -9063572008365012435L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("user_code")
    @ApiModelProperty("用户编码")
    private String userCode;

    @TableField("nick_name")
    @ApiModelProperty("用户昵称")
    private String nickName;

    @TableField("user_name")
    @ApiModelProperty("用户姓名")
    private String userName;

    @TableField("user_pwd")
    @ApiModelProperty("用户密码")
    private String userPwd;

    @TableField("org_code")
    @ApiModelProperty("部门编号")
    private String orgCode;

    @TableField("org_name")
    @ApiModelProperty("部门名称")
    private String orgName;

    @TableField("job_num")
    @ApiModelProperty("工号")
    private String jobNum;

    @TableField("phone")
    @ApiModelProperty("手机号")
    private String phone;

    @TableField("open_id")
    @ApiModelProperty("微信openID")
    private String openId;

    @TableField("email")
    @ApiModelProperty("邮箱")
    private String email;

    @TableField("state")
    @ApiModelProperty("状态(0:无效, 1:有效)")
    private String state;

    @TableField("create_time")
    @ApiModelProperty("创建时间")
    private Date createTime; //创建时间

    @TableField("creator")
    @ApiModelProperty("创建人")
    private String creator; //创建人

    @TableField("update_time")
    @ApiModelProperty("更新时间")
    private Date updateTime; //更新时间

    @TableField("editor")
    @ApiModelProperty("更新人")
    private String editor; //更新人

    @TableField("version")
    @ApiModelProperty("版本号")
    private Long version; //版本号（解决并发处理，记录更新时+1）

    @TableField("deleted")
    @ApiModelProperty("是否删除 0： 正常 1：已删除")
    private String deleted; //是否删除 0： 正常 1：已删除

    @TableField("remark")
    @ApiModelProperty("备注")
    private String remark; //备注

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}