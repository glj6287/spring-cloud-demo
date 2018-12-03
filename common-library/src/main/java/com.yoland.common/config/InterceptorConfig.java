package com.yoland.common.config;

import com.yoland.common.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author leo
 * @since 2018/7/27 8:46
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final StringRedisTemplate stringRedisTemplate;

    public InterceptorConfig(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加Jwt认证拦截器，排除登录接口
        addInterceptor(registry, new JwtInterceptor(stringRedisTemplate))
                .excludePathPatterns("/sys/login")
                .excludePathPatterns("/sys/getKaptchaImage")
                .excludePathPatterns("/upload")
                .excludePathPatterns("/exportExcel/getExcel/*");
    }

    private InterceptorRegistration addInterceptor(InterceptorRegistry registry, HandlerInterceptor interceptor) {
        // 为所有的拦截器指定排除swagger的地址
        return registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/error")
                .excludePathPatterns("/swagger**/**")
                .excludePathPatterns("/webjars**/**");
    }
}

