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
 * @author leo
 * @since 2018/7/27 10:55
 */
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "SysLog", description = "日志实体类")
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 日志类型[0异常日志,1正常日志]
     */
    @TableField("log_type_id")
    @ApiModelProperty("日志类型[0异常日志,1正常日志]")
    private Long logTypeId;

    /**
     * 日志标题[接口名]
     */
    @ApiModelProperty("日志标题[接口名]")
    private String title;

    /**
     * 操作ip地址
     */
    @TableField("remote_addr")
    @ApiModelProperty("操作ip地址")
    private String remoteAddr;

    /**
     * 用户代理
     */
    @TableField("user_agent")
    @ApiModelProperty("用户代理")
    private String userAgent;

    /**
     * 请求uri
     */
    @TableField("request_uri")
    @ApiModelProperty("请求uri")
    private String requestUri;

    /**
     * 操作方式
     */
    @ApiModelProperty("操作方式")
    private String method;

    /**
     * 操作提交的数据
     */
    @ApiModelProperty("操作提交的数据")
    private String params;

    /**
     * 异常信息
     */
    @ApiModelProperty("异常信息")
    private String exception;

    /**
     * 操作时间
     */
    @TableField("create_time")
    @ApiModelProperty("操作时间")
    private Date createTime;

    /**
     * 操作用户
     */
    @TableField("create_by")
    @ApiModelProperty("操作用户")
    private Long createBy;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
