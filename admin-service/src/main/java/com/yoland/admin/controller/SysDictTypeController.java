package com.yoland.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import org.springframework.web.bind.annotation.*;

import static com.yoland.common.utils.BeanUtil.copy;

/**
 * 字典类型管理Controller
 * 
 * @author autoCode
 * @version 2017-10-27 14:17
 */
@RestController
@RequestMapping("/metadevice/sysDictType")
@ApiModel(value = "SysDictTypeController", description = "字典类型管理")
@Api(description = "字典类型管理")
public class SysDictTypeController {

}
