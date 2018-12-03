package com.yoland.admin.service;

import com.yoland.admin.dto.SysUserDTO;
import com.yoland.admin.dto.SysUserVo;
import com.yoland.common.entity.original.SysUser;
import com.yoland.common.utils.RestResult;

import java.util.List;

/**
 *
 * @Description: TODO
 * @Author guanlijun
 * @Date 2018/11/26 14:29
 */
public interface UserService {

    /**
     * 查询用户列表分页
     * @param userVo
     * @return
     */
    RestResult<List<SysUser>> list(SysUserVo userVo);

    RestResult<Void> add(SysUserDTO user);

    RestResult<Void> remove(String userCode);

    RestResult<Void> update(SysUserDTO user);
}
