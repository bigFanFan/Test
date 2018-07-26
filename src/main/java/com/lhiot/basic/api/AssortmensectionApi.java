package com.lhiot.basic.api;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.domain.Assortmensection;
import com.lhiot.basic.service.AssortmensectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:套餐板块分类接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "套餐板块分类接口")
@Slf4j
@RestController
@RequestMapping("/assortmensection")
public class AssortmensectionApi {

    private final AssortmensectionService assortmensectionService;

    @Autowired
    public AssortmensectionApi(AssortmensectionService assortmensectionService) {
        this.assortmensectionService = assortmensectionService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加套餐板块分类")
    @ApiImplicitParam(paramType = "body", name = "assortmensection", value = "要添加的套餐板块分类", required = true, dataType = "Assortmensection")
    public ResponseEntity<Integer> create(@RequestBody Assortmensection assortmensection) {
        log.debug("添加套餐板块分类\t param:{}",assortmensection);
        
        return ResponseEntity.ok(assortmensectionService.create(assortmensection));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新套餐板块分类")
    @ApiImplicitParam(paramType = "body", name = "assortmensection", value = "要更新的套餐板块分类", required = true, dataType = "Assortmensection")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody Assortmensection assortmensection) {
        log.debug("根据id更新套餐板块分类\t id:{} param:{}",id,assortmensection);
        assortmensection.setId(id);
        
        return ResponseEntity.ok(assortmensectionService.updateById(assortmensection));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除套餐板块分类")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除套餐板块分类的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除套餐板块分类\t param:{}",ids);
        
        return ResponseEntity.ok(assortmensectionService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询套餐板块分类", notes = "根据id查询套餐板块分类")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<Assortmensection> findAssortmensection(@PathVariable("id") Long id) {

        return ResponseEntity.ok(assortmensectionService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询套餐板块分类分页列表")
    public ResponseEntity<PagerResultObject<Assortmensection>> pageQuery(Assortmensection assortmensection){
        log.debug("查询套餐板块分类分页列表\t param:{}",assortmensection);
        
        return ResponseEntity.ok(assortmensectionService.pageList(assortmensection));
    }

    @ApiOperation(value = "根据位置查询套餐版块", notes = "根据位置查询套餐版块")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nameEn", value = "板块英语名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "applicationType", value = "应用类型id", required = true, dataType = "Long")
    }
    )
    @GetMapping("/section")
    public ResponseEntity findAssortmentSections(@RequestParam("nameEn") String nameEn,
                                                 @RequestParam("applicationType") Long applicationType) {
        return ResponseEntity.ok(assortmensectionService.findAssortmentSections(nameEn,applicationType));
    }
    
}
