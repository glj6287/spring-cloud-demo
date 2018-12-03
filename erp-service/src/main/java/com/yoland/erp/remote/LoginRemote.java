package com.yoland.erp.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value = "admin-service", fallback = LoginRemoteHystrix.class)
public interface LoginRemote {

    @GetMapping("/sys/getAdminPort")
    public String getAdminPort() ;
}
