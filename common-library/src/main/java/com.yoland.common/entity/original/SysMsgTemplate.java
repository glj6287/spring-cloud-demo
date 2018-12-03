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

@TableName("t_sys_msg_template")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysMsgTemplate extends Model<SysMsgTemplate> {
    private static final long serialVersionUID = 8468228073424555441L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("tpl_type")
    @ApiModelProperty("模板类型")
    private String tplType;

    @TableField("tpl_code")
    @ApiModelProperty("模板编号")
    private String tplCode;

    @TableField("tpl_name")
    @ApiModelProperty("模板名称")
    private String tplName;

    @TableField("tpl_content")
    @ApiModelProperty("模板内容")
    private String tplContent;


    @TableField("state")
    @ApiModelProperty("状态（0正常 1删除 2停用）")
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