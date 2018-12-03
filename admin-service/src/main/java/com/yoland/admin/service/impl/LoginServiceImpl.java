package com.yoland.admin.service.impl;

import com.yoland.admin.dto.LoginDTO;
import com.yoland.admin.dto.LoginVO;
import com.yoland.admin.dto.UpdatePwdDTO;
import com.yoland.admin.mapper.SysUserMapper;
import com.yoland.admin.service.LoginService;
import com.yoland.common.entity.original.SysUser;
import com.yoland.common.utils.JwtUtil;
import com.yoland.common.utils.PasswordUtil;
import com.yoland.common.utils.RestResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.yoland.common.constant.ErrorCode.*;
import static com.yoland.common.constant.ErrorCode.JWT_ILLEGAL_TOKEN;
import static com.yoland.common.constant.ErrorCode.USER_AUTH_FAILED;
import static com.yoland.common.constant.ErrorCode.USER_NOT_EXIST;
import static com.yoland.common.constant.ErrorCode.USER_PWD_FAILED;
import static com.yoland.common.interceptor.JwtInterceptor.SESSION_EXPIRED_TIME;
import static com.yoland.common.utils.PasswordUtil.encrypt;
import static com.yoland.common.utils.RestResult.fail;
import static com.yoland.common.utils.RestResult.success;
import static com.xiaoleilu.hutool.lang.Base64.decodeStr;
import static com.xiaoleilu.hutool.lang.Base64.encode;

/**
 * @Description: 用户登陆服务
 * @Author guanlj
 * @Date 2018/11/26 14:45
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SysUserMapper sysUserMapper;
    /**
     * 用户登录redis key标志
     */
    private static final String REDIS_LOGIN_USER_KEY = "/loginUser/%s/%s";


    @Override
    public RestResult<LoginVO> login(LoginDTO loginUser) {
        RestResult<LoginVO> restResult;
        SysUser sysUser = sysUserMapper.login(loginUser);

        if (sysUser == null) {
            restResult = fail(USER_NOT_EXIST);
        } else if (!PasswordUtil.validatePassword(loginUser.getUserPwd(), sysUser.getUserPwd())) {
            restResult = fail(USER_AUTH_FAILED);
        } else {
            LoginVO loginVO = new LoginVO();
            // 清空密码
            sysUser.setUserPwd(null);
            loginVO.setSysUser(sysUser);

            // 用户登录redis key标志
            String redisUserLoginKey = String.format(REDIS_LOGIN_USER_KEY,
                    sysUser.getJobNum(),
                    UUID.randomUUID().toString()
            );

            // 取消单点登录，使用经过Base64加密的字符串作为session
            loginVO.setToken(encode(redisUserLoginKey));
            //redis存储登陆信息
            stringRedisTemplate
                    .boundValueOps(redisUserLoginKey)
                    .set(JwtUtil.encode(sysUser), SESSION_EXPIRED_TIME, TimeUnit.MINUTES);
            //返回结果集
            restResult = success(loginVO);
        }

        return restResult;
    }

    @Override
    public RestResult<Void> logout(String sessionId) {
        //真正的token的key
        String rawRedisUserLoginKey = decodeStr(sessionId);
        String token = stringRedisTemplate.boundValueOps(rawRedisUserLoginKey).get();
        if (StringUtils.isBlank(token)){
            return fail(JWT_ILLEGAL_TOKEN);
        }
        //清空缓存
        stringRedisTemplate.delete(rawRedisUserLoginKey);
        return success(null);
    }

    @Override
    public RestResult<String> changePassword(UpdatePwdDTO pwdDTO) {
        //huoq当前登陆用户
        SysUser user = JwtUtil.getCurrentUser();
        if (user == null){
            return fail(USER_NOT_EXIST);
        }
        SysUser sysUser = sysUserMapper.selectById(user.getId());
        //比较旧密码是否一致
        if (!PasswordUtil.validatePassword(pwdDTO.getOldPwd(), sysUser.getUserPwd())){
            return fail(USER_PWD_FAILED);
        }
        SysUser upUser = new SysUser();
        upUser.setId(user.getId());
        upUser.setUserPwd(encrypt(pwdDTO.getNewPwd()));
        upUser.setUpdateTime(new Date());
        upUser.setEditor(user.getUserCode());
        sysUserMapper.updateById(upUser);
        //更新用户密码，清除token 重新登陆
        String redisUserLoginKey = String.format(REDIS_LOGIN_USER_KEY, user.getJobNum(), "*");
        Set<String> keys = stringRedisTemplate.keys(redisUserLoginKey);
        stringRedisTemplate.delete(keys);
        return success(null);
    }
}
