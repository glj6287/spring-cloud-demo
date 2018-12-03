package com.yoland.common.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author leo
 * @since 2018/7/27 8:46
 */
@Configuration
public class JsonConfig {
    /**
     * 过滤值为Null的字段
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJson() {

        // 修复因为Long值过大导致json转换数值失真
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);

        return jackson2ObjectMapperBuilder -> jackson2ObjectMapperBuilder
                .serializationInclusion(JsonInclude.Include.NON_NULL)
                .indentOutput(true)
                .modules(simpleModule)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
