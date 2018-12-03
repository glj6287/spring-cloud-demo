package com.yoland.admin.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yoland.admin.dto.SysUserDTO;
import com.yoland.admin.dto.SysUserVo;
import com.yoland.admin.mapper.SysUserMapper;
import com.yoland.admin.service.UserService;
import com.yoland.common.constant.Constant;
import com.yoland.common.constant.ErrorCode;
import com.yoland.common.entity.original.SysUser;
import com.yoland.common.utils.BeanUtil;
import com.yoland.common.utils.JwtUtil;
import com.yoland.common.utils.RestResult;
import com.yoland.common.utils.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.yoland.common.utils.PasswordUtil.encrypt;
import static com.yoland.common.utils.RestResult.fail;
import static com.yoland.common.utils.RestResult.success;

/**
 * @Description: TODO
 * @Author guanlj
 * @Date 2018/11/26 14:33
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public RestResult<List<SysUser>> list(SysUserVo userVo) {
        try {
            PageHelper.startPage(userVo.getPage(), userVo.getPageSize());
            List<SysUser> list = sysUserMapper.selectUserPage(userVo);
            PageInfo<SysUser> pageInfo = new PageInfo<>(list);
            long total = pageInfo.getTotal(); //获取总记录数
            return success(list,total);
        } catch (Exception e) {
            throw new RuntimeException("查询用户列表异常");
        }
    }

    @Override
    public RestResult<Void> add(SysUserDTO user) {
        //登陆用户
        try {
            SysUser loginUser = JwtUtil.getCurrentUser();
            user.setUserCode(UUIDGenerator.generateSequence("SYSUSER",4));//生成唯一用户编号
            user.setCreateTime(new Date());
            user.setCreator(loginUser.getUserCode());
            user.setUserPwd(StringUtils.isNotBlank(user.getUserPwd())?encrypt(user.getUserPwd()):encrypt("123456"));
            user.setVersion(1L);
            int count = sysUserMapper.insert(BeanUtil.copy(user,SysUser.class));
            if (count < 1){
                return fail(ErrorCode.SAVE_ERROR);
            }
            return success(null);
        } catch (Exception e) {
            return fail(ErrorCode.SYSTEM_ERROR);
        }
    }

    @Override
    public RestResult<Void> remove(String userCode) {
        //登陆用户
        SysUser loginUser = JwtUtil.getCurrentUser();
        SysUser user = new SysUser();
        user.setEditor(loginUser.getUserCode());
        user.setUpdateTime(new Date());
        user.setDeleted(Constant.DATA_DELETED);
        EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        wrapper.eq("user_code",userCode);
        int count = sysUserMapper.update(user,wrapper);
        if (count<0){
            return fail(ErrorCode.DELETE_ERROR);
        }
        return success(null);
    }

    @Override
    public RestResult<Void> update(SysUserDTO user) {
        //登陆用户
        SysUser loginUser = JwtUtil.getCurrentUser();
        user.setEditor(loginUser.getUserCode());
        user.setUpdateTime(new Date());
        EntityWrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        wrapper.eq("user_code",user.getUserCode());
        int count = sysUserMapper.update(BeanUtil.copy(user,SysUser.class),wrapper);
        if (count < 1){
            return fail(ErrorCode.UPDATE_ERROR);
        }
        return success(null);
    }
}
