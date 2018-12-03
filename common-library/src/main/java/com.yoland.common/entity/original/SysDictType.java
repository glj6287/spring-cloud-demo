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
 * 字典类型表
 */
@TableName("t_sys_dict_type")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysDictType extends Model<SysDictType> {
    private static final long serialVersionUID = 2492783213578176717L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("dict_type")
    @ApiModelProperty("字典类型")
    private String dictType;

    @TableField("dict_name")
    @ApiModelProperty("字典类型名称")
    private String dictName;

    @TableField("state")
    @ApiModelProperty("是否有效 1有效，0无效")
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