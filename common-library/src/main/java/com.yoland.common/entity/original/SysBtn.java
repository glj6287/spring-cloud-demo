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
 * 系统按钮表
 */
@TableName("t_sys_btn")
@EqualsAndHashCode(callSuper = false)
@Data
@ApiModel
public class SysBtn extends Model<SysBtn> {

    private static final long serialVersionUID = 6563367604343684836L;

    @ApiModelProperty("主键")
    private Long id;

    @TableField("btn_code")
    @ApiModelProperty("按钮编码")
    private String btnCode;

    @TableField("btn_name")
    @ApiModelProperty("按钮名称")
    private String btnName;

    @TableField("btn_title")
    @ApiModelProperty("按钮提示说明")
    private String btnTitle;

    @TableField("menu_code")
    @ApiModelProperty("菜单编码")
    private String menuCode;

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