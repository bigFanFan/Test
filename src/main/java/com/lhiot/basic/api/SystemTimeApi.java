package com.lhiot.basic.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 系统时间接口
 * @author: Limiaojun
 * @create: 2018-06-14 16:01
 **/
@RequestMapping("/system/time")
public class SystemTimeApi {

    @GetMapping("/current")
    @ApiOperation(value = "获取服务器系统时间")
    public ResponseEntity<String> getTime() {
        return ResponseEntity.ok(String.valueOf(System.currentTimeMillis()));
    }
}
