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
import com.lhiot.basic.domain.SystemSetting;
import com.lhiot.basic.service.SystemSettingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* Description:系统设置参数接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "系统设置参数接口")
@Slf4j
@RestController
@RequestMapping("/systemSetting")
public class SystemSettingApi {

    private final SystemSettingService systemSettingService;

    @Autowired
    public SystemSettingApi(SystemSettingService systemSettingService) {
        this.systemSettingService = systemSettingService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加系统设置参数")
    @ApiImplicitParam(paramType = "body", name = "systemSetting", value = "要添加的系统设置参数", required = true, dataType = "SystemSetting")
    public ResponseEntity<Integer> create(@RequestBody SystemSetting systemSetting) {
        log.debug("添加系统设置参数\t param:{}",systemSetting);
        
        return ResponseEntity.ok(systemSettingService.create(systemSetting));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新系统设置参数")
    @ApiImplicitParam(paramType = "body", name = "systemSetting", value = "要更新的系统设置参数", required = true, dataType = "SystemSetting")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody SystemSetting systemSetting) {
        log.debug("根据id更新系统设置参数\t id:{} param:{}",id,systemSetting);
        systemSetting.setId(id);
        
        return ResponseEntity.ok(systemSettingService.updateById(systemSetting));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除系统设置参数")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除系统设置参数的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除系统设置参数\t param:{}",ids);
        
        return ResponseEntity.ok(systemSettingService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询系统设置参数", notes = "根据id查询系统设置参数")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<SystemSetting> findSystemSetting(@PathVariable("id") Long id) {

        return ResponseEntity.ok(systemSettingService.selectById(id));
    }

    @ApiOperation(value = "根据系统设置key查询系统设置参数", notes = "根据系统设置key查询系统设置参数")
    @ApiImplicitParam(paramType = "path", name = "name", value = "系统设置key", required = true, dataType = "String")
    @GetMapping("/findByName/{name}")
    public ResponseEntity<SystemSetting> findByName(@PathVariable("name") String name) {

        return ResponseEntity.ok(systemSettingService.findByName(name));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询系统设置参数分页列表")
    public ResponseEntity<PagerResultObject<SystemSetting>> pageQuery(SystemSetting systemSetting){
        log.debug("查询系统设置参数分页列表\t param:{}",systemSetting);
        
        return ResponseEntity.ok(systemSettingService.pageList(systemSetting));
    }
    
}
