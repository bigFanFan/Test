package com.lxs.code.api;

import com.lxs.code.domain.Product;
import com.lxs.code.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lxs.common.PagerResultObject;

/**
* Description:商品信息接口类
* @author Limiaojun
* @date 2018/07/23
*/
@Api(description = "商品信息接口")
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductApi {

    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加商品信息")
    @ApiImplicitParam(paramType = "body", name = "product", value = "要添加的商品信息", required = true, dataType = "Product")
    public ResponseEntity<Integer> create(@RequestBody Product product) {
        log.debug("添加商品信息\t param:{}",product);
        
        return ResponseEntity.ok(productService.create(product));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新商品信息")
    @ApiImplicitParam(paramType = "body", name = "product", value = "要更新的商品信息", required = true, dataType = "Product")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody Product product) {
        log.debug("根据id更新商品信息\t id:{} param:{}",id,product);
        product.setId(id);
        
        return ResponseEntity.ok(productService.updateById(product));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除商品信息")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除商品信息的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除商品信息\t param:{}",ids);
        
        return ResponseEntity.ok(productService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询商品信息", notes = "根据id查询商品信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable("id") Long id) {

        return ResponseEntity.ok(productService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询商品信息分页列表")
    public ResponseEntity<PagerResultObject<Product>> pageQuery(Product product){
        log.debug("查询商品信息分页列表\t param:{}",product);
        
        return ResponseEntity.ok(productService.pageList(product));
    }
    
}
