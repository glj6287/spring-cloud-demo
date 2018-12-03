package com.yoland.common.config;

import com.yoland.common.config.model.RedisConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author leo
 * @since 2018/7/27 8:47
 */
@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    @ConfigurationProperties("custom.redis")
    public RedisConfiguration redisConfiguration() {
        return new RedisConfiguration();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisConfiguration redisConfiguration) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfiguration.getMaxTotal());
        jedisPoolConfig.setMinIdle(redisConfiguration.getMinIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfiguration.getMaxWait());
        jedisPoolConfig.setTestOnBorrow(redisConfiguration.getTestOnBorrow());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        jedisConnectionFactory.setHostName(redisConfiguration.getHostname());
        return jedisConnectionFactory;
    }

}
