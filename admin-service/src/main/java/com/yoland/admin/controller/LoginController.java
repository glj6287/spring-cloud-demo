package com.yoland.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yoland.admin.dto.LoginDTO;
import com.yoland.admin.dto.LoginVO;
import com.yoland.admin.dto.UpdatePwdDTO;
import com.yoland.admin.service.LoginService;
import com.yoland.common.utils.RestResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.image.BufferedImage;

import static com.yoland.common.constant.ErrorCode.JWT_NOT_EXIST;
import static com.yoland.common.utils.RestResult.fail;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * 登陆接口
 */
@RestController
@RequestMapping("/sys")
@Api(description = "登录管理")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public RestResult<LoginVO> login(@Valid @RequestBody LoginDTO loginUser) {
        return loginService.login(loginUser);
    }

    /**
     * 退出登陆
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("退出登陆")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<Void> logout(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //请求头sessionId
        String sessionId = request.getHeader(AUTHORIZATION);
        if (StringUtils.isBlank(sessionId)) {
            return fail(JWT_NOT_EXIST);
        }
        return loginService.logout(sessionId);
    }

    /**
     * 修改密码
     * @param pwdDTO
     * @return
     */
    @PostMapping("/changePwd")
    @ApiOperation("修改密码")
    @ApiImplicitParam(name = "Authorization", value = "token", required = true, dataType = "string", paramType = "header")
    public RestResult<String> changePassword(@Valid @RequestBody UpdatePwdDTO pwdDTO){
        return loginService.changePassword(pwdDTO);
    }
    /**
     * 验证码获取图片
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/getKaptchaImage")
    public void getKaptchaImage(HttpServletRequest request,HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = defaultKaptcha.createText();
        // store the text in the session
        //将验证码存到session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = defaultKaptcha.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
