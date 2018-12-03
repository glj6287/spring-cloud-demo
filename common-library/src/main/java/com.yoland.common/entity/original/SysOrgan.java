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
 * 组织机构表
 */
@TableName("t_sys_organ")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysOrgan extends Model<SysOrgan> {

    private static final long serialVersionUID = 1844003386568558352L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("org_code")
    @ApiModelProperty("部门编码")
    private String orgCode;

    @TableField("org_name")
    @ApiModelProperty("部门名称")
    private String orgName;

    @TableField("pid_code")
    @ApiModelProperty("父级编码")
    private String pidCode;

    @TableField("duty_code")
    @ApiModelProperty("部门负责人编号")
    private String dutyCode;

    @TableField("duty_name")
    @ApiModelProperty("部门负责人姓名")
    private String dutyName;

    @TableField("order_by")
    @ApiModelProperty("排序")
    private Integer orderBy;


    @TableField("state")
    @ApiModelProperty("是否有效  1:有效   0:无效")
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