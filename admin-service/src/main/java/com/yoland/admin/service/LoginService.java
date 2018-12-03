package com.yoland.admin.service;

import com.yoland.admin.dto.LoginDTO;
import com.yoland.admin.dto.LoginVO;
import com.yoland.admin.dto.UpdatePwdDTO;
import com.yoland.common.utils.RestResult;

/**
 * @author leo
 * @since 2018/11/26 14:47
 */
public interface LoginService {

    /**
     * 用户登陆
     * @param loginUser
     * @return
     */
    public RestResult<LoginVO> login(LoginDTO loginUser);

    /**
     * 用户注销
     * @return
     */
    public RestResult<Void> logout(String sessionId);

    /**
     * 修改密码（用户修改）
     * @param pwdDTO
     * @return
     */
    public RestResult<String> changePassword(UpdatePwdDTO pwdDTO);

}
