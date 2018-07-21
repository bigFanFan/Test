package com.lhiot.basic.api;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.domain.ProductStandard;
import com.lhiot.basic.service.ProducStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
* Description:商品规格接口类
* @author Limiaojun
* @date 2018/07/20
*/
@Api(description = "商品规格接口")
@Slf4j
@RestController
@RequestMapping("/wxsmall/products/standards")
public class ProducStandardApi {

    private final ProducStandardService producstandardService;

    @Autowired
    public ProducStandardApi(ProducStandardService producstandardService) {
        this.producstandardService = producstandardService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "添加商品规格")
    @ApiImplicitParam(paramType = "body", name = "producstandard", value = "要添加的商品规格", required = true, dataType = "Producstandard")
    public ResponseEntity<Integer> create(@RequestBody ProductStandard producstandard) {
        log.debug("添加商品规格\t param:{}",producstandard);
        
        return ResponseEntity.ok(producstandardService.create(producstandard));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "根据id更新商品规格")
    @ApiImplicitParam(paramType = "body", name = "producstandard", value = "要更新的商品规格", required = true, dataType = "Producstandard")
    public ResponseEntity<Integer> update(@PathVariable("id") Long id,@RequestBody ProductStandard producstandard) {
        log.debug("根据id更新商品规格\t id:{} param:{}",id,producstandard);
        producstandard.setId(id);
        
        return ResponseEntity.ok(producstandardService.updateById(producstandard));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除商品规格")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除商品规格的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除商品规格\t param:{}",ids);
        
        return ResponseEntity.ok(producstandardService.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询商品规格", notes = "根据id查询商品规格")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<ProductStandard> findProducstandard(@PathVariable("id") Long id) {

        return ResponseEntity.ok(producstandardService.selectById(id));
    }
    
    @GetMapping("/page/query")
    @ApiOperation(value = "查询商品规格分页列表")
    public ResponseEntity<PagerResultObject<ProductStandard>> pageQuery(ProductStandard producstandard){
        log.debug("查询商品规格分页列表\t param:{}",producstandard);
        
        return ResponseEntity.ok(producstandardService.pageList(producstandard));
    }

    @SuppressWarnings("rawtypes")
    @ApiOperation(value = "根据规格ids,或者barcode查找", notes = "根据规格ids,或者barcode查找")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "key", value = "ids或者barcode", required = true,
                    dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "value", value = "ids或者barcode的值", required = true,
                    dataType = "String") })
    @GetMapping("/find/{key}/{value}")
    public ResponseEntity<ArrayObject> findProductsStandardResults(@PathVariable String key,
                                                                   @PathVariable String value) {
        log.debug("根据规格ids,或者barcode查找\t param:{} {}", key,value);

        return ResponseEntity.ok(ArrayObject.of(producstandardService.findGoodsStandards(key, value)));
    }

}
