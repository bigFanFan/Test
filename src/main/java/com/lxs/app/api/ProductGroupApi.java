package com.lxs.app.api;

import com.lxs.app.domain.ProductGroup;
import com.lxs.app.service.ProductGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lxs.common.PagerResultObject;

/**
* Description:商品分类接口类
* @author Limiaojun
* @date 2018/06/07
*/
@Api(description = "商品分类接口")
@Slf4j
@RestController
@RequestMapping("/product/group")
public class ProductGroupApi {

    private final ProductGroupService productGroupService;

    @Autowired
    public ProductGroupApi(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @PostMapping
    @ApiOperation(value = "添加商品分类")
    @ApiImplicitParam(paramType = "body", name = "productGroup", value = "要添加的商品分类", required = true, dataType = "ProductGroup")
    public ResponseEntity<Integer> create(@RequestBody ProductGroup productGroup) {
        log.debug("添加商品分类\t param:{}",productGroup);

        return ResponseEntity.ok(productGroupService.create(productGroup));
    }

    @PutMapping
    @ApiOperation(value = "根据id更新商品分类")
    @ApiImplicitParam(paramType = "body", name = "productGroup", value = "要更新的商品分类", required = true, dataType = "ProductGroup")
    public ResponseEntity<Integer> update(@RequestBody ProductGroup productGroup) {
        log.debug("根据id更新商品分类\t param:{}",productGroup);
        
        return ResponseEntity.ok(productGroupService.updateById(productGroup));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除商品分类")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除商品分类的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除商品分类\t param:{}",ids);
        
        return ResponseEntity.ok(productGroupService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询商品分类", notes = "根据id查询商品分类")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<ProductGroup> findProductGroup(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productGroupService.selectById(id));
    }
    
    @PostMapping("/page/query")
    @ApiOperation(value = "查询商品分类分页列表")
    public ResponseEntity<PagerResultObject<ProductGroup>> pageQuery(ProductGroup productGroup){
        log.debug("查询商品分类分页列表\t param:{}",productGroup);
        
        return ResponseEntity.ok(productGroupService.pageList(productGroup));
    }
    
}
