package com.yoland.erp.controller;

import com.yoland.erp.remote.LoginRemote;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 房源管理
 */
@RestController
@Api(description = "房源管理")
public class HouseController {

    @Autowired
    LoginRemote loginRemote;
    @Value("${server.port}")
    String port;

    /**
     * 获取用户服务的端口
     * @return
     */
    @GetMapping("/house/getErpPort")
    public String getErpPort() {
        return "erp-service port：" + port;
    }

    /**
     * 获取订单服务的端口
     * @return
     */
    @GetMapping("/house/getAdminPort")
    public String getAdminPort() {
        return "erp-admin-service port：" + loginRemote.getAdminPort();
    }

}
