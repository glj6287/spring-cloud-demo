package com.yoland.admin.controller;

import com.yoland.admin.dto.SysUserDTO;
import com.yoland.admin.dto.SysUserVo;
import com.yoland.admin.service.UserService;
import com.yoland.common.entity.original.SysUser;
import com.yoland.common.utils.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author guanlj
 * @version 2018-11-27 14:17
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户管理")
public class SysUserController {

    @Autowired
    private UserService userService;

    @PostMapping("/list")
    @ApiOperation("查询用户")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<List<SysUser>> list(@RequestBody SysUserVo userVo) {
        return userService.list(userVo);
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<Void> add(@Valid @RequestBody SysUserDTO user) {
        return userService.add(user);
    }

    @GetMapping("/remove/{userCode}")
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<Void> remove(@PathVariable String userCode) {
        return userService.remove(userCode);
    }

    @PostMapping("/update")
    @ApiOperation("修改用户")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<Void> edit(@Valid @RequestBody SysUserDTO user) {
        return userService.update(user);
    }

}
