package com.lhiot.basic.api;

import com.lhiot.basic.domain.AssortmensectionRelation;
import com.lhiot.basic.service.AssortmensectionRelationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:板块套餐关联接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "板块套餐关联接口")
@Slf4j
@RestController
@RequestMapping("/assortmensectionRelation")
public class AssortmensectionRelationApi {

    private final AssortmensectionRelationService assortmensectionRelationService;

    @Autowired
    public AssortmensectionRelationApi(AssortmensectionRelationService assortmensectionRelationService) {
        this.assortmensectionRelationService = assortmensectionRelationService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加板块套餐关联")
    @ApiImplicitParam(paramType = "body", name = "assortmensectionRelation", value = "要添加的板块套餐关联", required = true, dataType = "AssortmensectionRelation")
    public ResponseEntity<Integer> create(@RequestBody AssortmensectionRelation assortmensectionRelation) {
        log.debug("添加板块套餐关联\t param:{}",assortmensectionRelation);
        
        return ResponseEntity.ok(assortmensectionRelationService.create(assortmensectionRelation));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新板块套餐关联")
    @ApiImplicitParam(paramType = "body", name = "assortmensectionRelation", value = "要更新的板块套餐关联", required = true, dataType = "AssortmensectionRelation")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody AssortmensectionRelation assortmensectionRelation) {
        log.debug("根据id更新板块套餐关联\t id:{} param:{}",id,assortmensectionRelation);
        assortmensectionRelation.setId(id);
        
        return ResponseEntity.ok(assortmensectionRelationService.updateById(assortmensectionRelation));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除板块套餐关联")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除板块套餐关联的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除板块套餐关联\t param:{}",ids);
        
        return ResponseEntity.ok(assortmensectionRelationService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询板块套餐关联", notes = "根据id查询板块套餐关联")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<AssortmensectionRelation> findAssortmensectionRelation(@PathVariable("id") Long id) {

        return ResponseEntity.ok(assortmensectionRelationService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询板块套餐关联分页列表")
    public ResponseEntity<PagerResultObject<AssortmensectionRelation>> pageQuery(AssortmensectionRelation assortmensectionRelation){
        log.debug("查询板块套餐关联分页列表\t param:{}",assortmensectionRelation);
        
        return ResponseEntity.ok(assortmensectionRelationService.pageList(assortmensectionRelation));
    }
    
}
