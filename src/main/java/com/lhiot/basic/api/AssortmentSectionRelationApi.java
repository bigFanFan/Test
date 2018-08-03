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
import com.lhiot.basic.domain.AssortmentSectionRelation;
import com.lhiot.basic.service.AssortmentSectionRelationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* Description:板块套餐关联接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "板块套餐关联接口")
@Slf4j
@RestController
@RequestMapping("/assortmentSectionRelation")
public class AssortmentSectionRelationApi {

    private final AssortmentSectionRelationService assortmentSectionRelationService;

    @Autowired
    public AssortmentSectionRelationApi(AssortmentSectionRelationService assortmentSectionRelationService) {
        this.assortmentSectionRelationService = assortmentSectionRelationService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加板块套餐关联")
    @ApiImplicitParam(paramType = "body", name = "assortmentSectionRelation", value = "要添加的板块套餐关联", required = true, dataType = "AssortmentSectionRelation")
    public ResponseEntity<Integer> create(@RequestBody AssortmentSectionRelation assortmentSectionRelation) {
        log.debug("添加板块套餐关联\t param:{}",assortmentSectionRelation);
        
        return ResponseEntity.ok(assortmentSectionRelationService.create(assortmentSectionRelation));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新板块套餐关联")
    @ApiImplicitParam(paramType = "body", name = "assortmentSectionRelation", value = "要更新的板块套餐关联", required = true, dataType = "AssortmentSectionRelation")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody AssortmentSectionRelation assortmentSectionRelation) {
        log.debug("根据id更新板块套餐关联\t id:{} param:{}",id,assortmentSectionRelation);
        assortmentSectionRelation.setId(id);
        
        return ResponseEntity.ok(assortmentSectionRelationService.updateById(assortmentSectionRelation));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除板块套餐关联")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除板块套餐关联的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除板块套餐关联\t param:{}",ids);
        
        return ResponseEntity.ok(assortmentSectionRelationService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询板块套餐关联", notes = "根据id查询板块套餐关联")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<AssortmentSectionRelation> findAssortmentSectionRelation(@PathVariable("id") Long id) {

        return ResponseEntity.ok(assortmentSectionRelationService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询板块套餐关联分页列表")
    public ResponseEntity<PagerResultObject<AssortmentSectionRelation>> pageQuery(AssortmentSectionRelation assortmentSectionRelation){
        log.debug("查询板块套餐关联分页列表\t param:{}",assortmentSectionRelation);
        
        return ResponseEntity.ok(assortmentSectionRelationService.pageList(assortmentSectionRelation));
    }
    
}
