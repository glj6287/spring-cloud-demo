package com.yoland.admin.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author leo
 * @since 2018/3/14 16:21
 */
@Data
@ApiModel(value = "MenuDTO", description = "菜单")
public class MenuDTO {

    private Long orgId;

    private Integer menuStatus;

    private Long menuTypeId;
}
