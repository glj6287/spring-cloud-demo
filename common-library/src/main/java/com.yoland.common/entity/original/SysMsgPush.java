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


@TableName("t_sys_msg_push")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysMsgPush extends Model<SysMsgPush> {

    private static final long serialVersionUID = 7206967593995154088L;
    @ApiModelProperty("主键")
    private Long id;

    @TableField("msg_type")
    @ApiModelProperty("消息类型（PC APP 短信 邮件 微信）")
    private String msgType;

    @TableField("tpl_code")
    @ApiModelProperty("消息模板编号")
    private String tplCode;

    @TableField("app_code")
    @ApiModelProperty("APP编码")
    private String appCode;

    @TableField("msg_title")
    @ApiModelProperty("消息标题")
    private String msgTitle;

    @TableField("msg_content")
    @ApiModelProperty("消息内容")
    private String msgContent;

    @TableField("receive_code")
    @ApiModelProperty("接受者账号")
    private String receiveCode;

    @TableField("receive_user_code")
    @ApiModelProperty("接受者用户编码")
    private String receiveUserCode;

    @TableField("receive_user_name")
    @ApiModelProperty("接受者用户姓名")
    private String receiveUserName;

    @TableField("send_user_code")
    @ApiModelProperty("发送者用户编码")
    private String sendUserCode;

    @TableField("send_user_name")
    @ApiModelProperty("发送者用户姓名")
    private String sendUserName;

    @TableField("send_date")
    @ApiModelProperty("发送时间")
    private String sendDate;

    @TableField("plan_push_date")
    @ApiModelProperty("计划推送时间")
    private String planPushDate;

    @TableField("push_number")
    @ApiModelProperty("推送尝试次数")
    private Integer pushNumber;

    @TableField("push_return_code")
    @ApiModelProperty("推送返回结果码")
    private String pushReturnCode;

    @TableField("push_return_content")
    @ApiModelProperty("推送返回的内容信息")
    private String pushReturnContent;

    @TableField("push_status")
    @ApiModelProperty("推送状态（0未推送 1成功  2失败 3推送中）")
    private String pushStatus;

    @TableField("biz_code")
    @ApiModelProperty("业务编码")
    private String bizCode;

    @TableField("biz_type")
    @ApiModelProperty("业务类型")
    private String bizType;

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