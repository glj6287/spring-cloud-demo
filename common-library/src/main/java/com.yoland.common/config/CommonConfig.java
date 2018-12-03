package com.yoland.common.config;

import com.yoland.common.interceptor.JwtInterceptor;
import com.yoland.common.interceptor.LogAspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author leo
 * @since 2018/7/27 8:45
 */
@Configuration
@Import({CorsConfig.class, JsonConfig.class, SwaggerConfig.class,
        GlobalExceptionConfig.class, InterceptorConfig.class,LogAspect.class,
        JwtInterceptor.class, RedisConfig.class,MybatisPlusConfig.class,KaptchaConfig.class})
public class CommonConfig {

}
