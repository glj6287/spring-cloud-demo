package com.yoland.common.interceptor;

import com.baomidou.mybatisplus.toolkit.Sequence;
import com.yoland.common.entity.original.SysLog;
import com.yoland.common.entity.original.SysUser;
import com.yoland.common.utils.IpUtil;
import com.yoland.common.utils.RestResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.alibaba.fastjson.JSON.toJSONString;
import static com.yoland.common.utils.JwtUtil.getCurrentUser;
import static com.yoland.common.utils.RestResult.OPT_SUCCESS_STATUS;

/**
 * @author leo
 * @since 2018/7/27 10:53
 */
@Aspect
@Configuration
@Slf4j
public class LogAspect {

    private static final Sequence SEQUENCE = new Sequence();

//    private final MqttClient logMqttClient;
//    private final String logTopic;
//
//    public LogAspect(MqttClient logMqttClient,String logTopic) {
//        this.logMqttClient = logMqttClient;
//        this.logTopic = logTopic;
//    }

    /**
     * 切入所有带有@ApiOperation注解的方法
     */
    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    void doController() {

    }

    @Around("doController()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        String uri = request.getRequestURI();
        String method = request.getMethod();
        String params = getArg(joinPoint);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

        if (result != null && result instanceof RestResult) {
            // 如果当前返回结果的数据项为空，且操作成功则自动填充空的数组
            RestResult restResult = ((RestResult) result);

            if (OPT_SUCCESS_STATUS.equals(restResult.getStatus())
                    && restResult.getResultData() == null) {
                //noinspection unchecked
                restResult.setResultData(new String[0]);
            }
        }

        SysUser sysUser = getCurrentUser();

        // 如果为登陆接口，则请求用户置空
        String loginName = sysUser != null ? sysUser.getUserName() : "无";

        log.debug("\n请求用户:{} 请求IP:{} 请求地址:{} 请求方法:{} 请求费时:{}ms\n请求参数:{}\n请求结果:{}",
                loginName, getIpAddress(request), uri, method, endTime - startTime, params, toJSONString(result));

        SysLog sysLog = new SysLog();
        sysLog.setId(SEQUENCE.nextId());
        sysLog.setLogTypeId(1L);
        sysLog.setTitle(request.getRequestURI());
        sysLog.setRemoteAddr(getIpAddress(request));
        sysLog.setUserAgent(request.getHeader(HttpHeaders.USER_AGENT));
        sysLog.setMethod(request.getMethod());
        sysLog.setRequestUri(request.getRequestURI());
        sysLog.setParams(params);
        sysLog.setCreateBy(sysUser != null ? sysUser.getId() : 0L);
        sysLog.setCreateTime(new Date());

        return result;
    }

    private String getArg(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return toJSONString(args);
    }

    private String getIpAddress(HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        if (ip == null || ip.length() == 0 ) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

