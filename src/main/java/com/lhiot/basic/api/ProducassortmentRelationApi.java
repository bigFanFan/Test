package com.lhiot.basic.api;

import com.lhiot.basic.domain.ProducassortmentRelation;
import com.lhiot.basic.service.ProducassortmentRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:套餐商品关联接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "套餐商品关联接口")
@Slf4j
@RestController
@RequestMapping("/producassortmentRelation")
public class ProducassortmentRelationApi {

    private final ProducassortmentRelationService producassortmentRelationService;

    @Autowired
    public ProducassortmentRelationApi(ProducassortmentRelationService producassortmentRelationService) {
        this.producassortmentRelationService = producassortmentRelationService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加套餐商品关联")
    @ApiImplicitParam(paramType = "body", name = "producassortmentRelation", value = "要添加的套餐商品关联", required = true, dataType = "ProducassortmentRelation")
    public ResponseEntity<Integer> create(@RequestBody ProducassortmentRelation producassortmentRelation) {
        log.debug("添加套餐商品关联\t param:{}",producassortmentRelation);
        
        return ResponseEntity.ok(producassortmentRelationService.create(producassortmentRelation));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新套餐商品关联")
    @ApiImplicitParam(paramType = "body", name = "producassortmentRelation", value = "要更新的套餐商品关联", required = true, dataType = "ProducassortmentRelation")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody ProducassortmentRelation producassortmentRelation) {
        log.debug("根据id更新套餐商品关联\t id:{} param:{}",id,producassortmentRelation);
        producassortmentRelation.setId(id);
        
        return ResponseEntity.ok(producassortmentRelationService.updateById(producassortmentRelation));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除套餐商品关联")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除套餐商品关联的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除套餐商品关联\t param:{}",ids);
        
        return ResponseEntity.ok(producassortmentRelationService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询套餐商品关联", notes = "根据id查询套餐商品关联")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<ProducassortmentRelation> findProducassortmentRelation(@PathVariable("id") Long id) {

        return ResponseEntity.ok(producassortmentRelationService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询套餐商品关联分页列表")
    public ResponseEntity<PagerResultObject<ProducassortmentRelation>> pageQuery(ProducassortmentRelation producassortmentRelation){
        log.debug("查询套餐商品关联分页列表\t param:{}",producassortmentRelation);
        
        return ResponseEntity.ok(producassortmentRelationService.pageList(producassortmentRelation));
    }
    
}
