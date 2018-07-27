package com.lhiot.basic.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.domain.Application;
import com.lhiot.basic.service.ApplicationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* Description:应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)接口")
@Slf4j
@RestController
@RequestMapping("/application")
public class ApplicationApi {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationApi(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)")
    @ApiImplicitParam(paramType = "body", name = "application", value = "要添加的应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)", required = true, dataType = "Application")
    public ResponseEntity<Integer> create(@RequestBody Application application) {
        log.debug("添加应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)\t param:{}",application);
        
        return ResponseEntity.ok(applicationService.create(application));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)")
    @ApiImplicitParam(paramType = "body", name = "application", value = "要更新的应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)", required = true, dataType = "Application")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody Application application) {
        log.debug("根据id更新应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)\t id:{} param:{}",id,application);
        application.setId(id);
        
        return ResponseEntity.ok(applicationService.updateById(application));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)\t param:{}",ids);
        
        return ResponseEntity.ok(applicationService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)", notes = "根据id查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<Application> findApplication(@PathVariable("id") Long id) {

        return ResponseEntity.ok(applicationService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)分页列表")
    public ResponseEntity<PagerResultObject<Application>> pageQuery(Application application){
        log.debug("查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)分页列表\t param:{}",application);
        
        return ResponseEntity.ok(applicationService.pageList(application));
    }
    
}
