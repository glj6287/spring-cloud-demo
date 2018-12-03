package com.yoland.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yoland.admin.dto.LoginDTO;
import com.yoland.admin.dto.SysUserVo;
import com.yoland.common.entity.original.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 根据账号查询登陆用户
     * @param loginDTO
     * @return
     */
    SysUser login(LoginDTO loginDTO);

    /**
     * 根据工号查询用户信息
     * @param jobNum
     * @return
     */
    SysUser selectByJobNumber(String jobNum);

    /**
     * 根据用户code查询用户信息
     * @param userCode
     * @return
     */
    SysUser selectByUserCode(String userCode);

    /**
     * 分页查询用户列表
     * @param userVo
     * @return
     */
    List<SysUser> selectUserPage(SysUserVo userVo);

}