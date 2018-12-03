package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author autoCode
 * @version 2017-10-27 14:22
 */
@Data
@ApiModel
public class OrgDTO {

    @ApiModelProperty("组织ID")
    @Min(0)
    private Long id;

    @ApiModelProperty("父级编号")
    @Min(0)
    @NotNull
    private Long parentId;

    @ApiModelProperty("区域id[市]")
    @Min(0)
    private Long regionId;

    @ApiModelProperty("组织名称")
    @NotNull
    @Size(max = 20)
    private String name;

    @ApiModelProperty("组织类型[yoland, customer, delivery], (只有yoland和经销商类型,才可以把区域分组赋给组织")
    @Pattern(regexp = "^(yoland|customer|delivery)$")
    private String type;

    @ApiModelProperty("地址)")
    @Size(max = 100)
    private String address;

    @ApiModelProperty("是否租户[true租户, false不是租户]")
    private Boolean tenantStatus;

    @ApiModelProperty("创建下属组织[false不允许,true允许]")
    private Boolean createChild;

    @ApiModelProperty("创建用户[false不允许,true允许]")
    private Boolean createUser;

    @ApiModelProperty("起租时间,root用户有权设定该字段，其他用户不能设定")
    private Date rentTime;

    @ApiModelProperty("到期时间,root用户有权设定该字段，其他用户不能设定")
    private Date expireTime;

    @ApiModelProperty("经度")
    @Pattern(regexp = "^-?1?[0-8]?[0-9](\\.[0-9]{1,8})?$")
    private String longi;

    @ApiModelProperty("维度")
    @Pattern(regexp = "^-?1?[0-8]?[0-9](\\.[0-9]{1,8})?$")
    private String lati;

    @ApiModelProperty("图片链接")
    private String photoUrl;

    @ApiModelProperty("备注")
    @Size(max = 200)
    private String orgRemarks;

}
