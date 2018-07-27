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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.service.AssortmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
* Description:商品套餐接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "商品套餐接口")
@Slf4j
@RestController
@RequestMapping("/assortments")
public class AssortmentApi {

    private final AssortmentService assortmentService;

    @Autowired
    public AssortmentApi(AssortmentService assortmentService) {
        this.assortmentService = assortmentService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加商品套餐")
    @ApiImplicitParam(paramType = "body", name = "assortment", value = "要添加的商品套餐", required = true, dataType = "Assortment")
    public ResponseEntity<Integer> create(@RequestBody Assortment assortment) {
        log.debug("添加商品套餐\t param:{}",assortment);
        
        return ResponseEntity.ok(assortmentService.create(assortment));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新商品套餐")
    @ApiImplicitParam(paramType = "body", name = "assortment", value = "要更新的商品套餐", required = true, dataType = "Assortment")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody Assortment assortment) {
        log.debug("根据id更新商品套餐\t id:{} param:{}",id,assortment);
        assortment.setId(id);
        
        return ResponseEntity.ok(assortmentService.updateById(assortment));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除商品套餐")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除商品套餐的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除商品套餐\t param:{}",ids);
        
        return ResponseEntity.ok(assortmentService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询商品套餐", notes = "根据id查询商品套餐")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<Assortment> findAssortment(@PathVariable("id") Long id) {

        return ResponseEntity.ok(assortmentService.selectById(id));
    }

    @ApiOperation(value = "根据关键字查询商品套餐", notes = "根据关键字查询商品套餐")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "keywords", value = "关键词", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "page", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "rows", value = "每页展示数量", required = true, dataType = "Integer")
      }
    )
    @GetMapping("/search")
    public ResponseEntity findAssortmentByKeywords(@RequestParam("keywords") String keywords,
                                                                     @RequestParam("page") int page,
                                                                     @RequestParam("rows") int rows) {
        return ResponseEntity.ok(ArrayObject.of(assortmentService.findAssortmentByKeywords(keywords,page,rows)));
    }

    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询商品套餐分页列表")
    public ResponseEntity<PagerResultObject<Assortment>> pageQuery(Assortment assortment){
        log.debug("查询商品套餐分页列表\t param:{}",assortment);
        
        return ResponseEntity.ok(assortmentService.pageList(assortment));
    }




}
