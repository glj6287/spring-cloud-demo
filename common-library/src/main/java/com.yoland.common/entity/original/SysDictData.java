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
 * 字典表
 */
@TableName("t_sys_dict_data")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysDictData extends Model<SysDictData> {
    private static final long serialVersionUID = -4148837763393269817L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("dict_code")
    @ApiModelProperty("字典Key")
    private String dictCode;

    @TableField("dict_value")
    @ApiModelProperty("字典数据名称")
    private String dictValue;

    @TableField("dict_type")
    @ApiModelProperty("字典类型CODE")
    private String dictType;

    @TableField("pid_code")
    @ApiModelProperty("字典数据上级CODE")
    private String pidCode;

    @TableField("state")
    @ApiModelProperty("是否有效 1有效，0无效")
    private String state;

    @TableField("order_by")
    @ApiModelProperty("排序")
    private Integer orderBy;

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