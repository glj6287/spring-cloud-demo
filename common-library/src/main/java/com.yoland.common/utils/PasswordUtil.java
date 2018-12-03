package com.yoland.common.utils;

import static org.apache.commons.codec.digest.DigestUtils.sha256Hex;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 密码加密工具
 * @author autoCode
 * @version 2017-09-25 08:52
 */
public final class PasswordUtil {

    private PasswordUtil() {
        throw new IllegalStateException();
    }

    /**
     * 使用SHA-256进行密码加密
     * @param plainPassword 密码原文
     */
    public static String encrypt(String plainPassword) {
        return sha256Hex(plainPassword);
    }

    public static boolean validatePassword(String plainPassword, String cipherPassword) {
        return isNotBlank(plainPassword) && encrypt(plainPassword).equals(cipherPassword);

    }

    public static void main(String[] args) {
        System.out.println(encrypt("123456"));
    }
}
