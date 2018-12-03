package com.yoland.common.config.model;

import lombok.Data;

/**
 * @author leo
 * @since 2018/7/27 8:48
 */
@Data
public class RedisConfiguration {

    /**
     * 主机名
     */
    private String hostname;

    /**
     * 最大连接数
     */
    private int maxTotal;

    /**
     * 最小空闲树
     */
    private int minIdle;

    private int maxWait;

    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private Boolean testWhileIdle;

}
