package com.yoland.erp.remote;


import org.springframework.stereotype.Component;

@Component
public class LoginRemoteHystrix implements LoginRemote {

    @Override
    public String getAdminPort() {
        return "admin service 调用失败！";
    }
}
