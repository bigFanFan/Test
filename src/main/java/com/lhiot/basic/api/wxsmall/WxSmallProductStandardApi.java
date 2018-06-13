package com.lhiot.basic.api.wxsmall;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.domain.WxSmallProductStandard;
import com.lhiot.basic.domain.out.WxSmallProductStandardResult;
import com.lhiot.basic.service.wxsmall.WxSmallProductStandardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
* Description:小程序商品规格接口类
* @author Limiaojun
* @date 2018/06/01
*/
@Api(description = "小程序商品规格接口")
@Slf4j
@RestController
@RequestMapping("/wxsmall/products/standards")
public class WxSmallProductStandardApi {

    private final WxSmallProductStandardService wxSmallProductStandardService;

    @Autowired
    public WxSmallProductStandardApi(WxSmallProductStandardService wxSmallProductStandardService) {
        this.wxSmallProductStandardService = wxSmallProductStandardService;
    }

    @PostMapping
    @ApiOperation(value = "添加小程序商品规格")
    @ApiImplicitParam(paramType = "body", name = "wxSmallProductStandard", value = "要添加的小程序商品规格", required = true, dataType = "WxSmallProductStandard")
    public ResponseEntity<Integer> create(@RequestBody WxSmallProductStandard wxSmallProductStandard) {
        log.debug("添加小程序商品规格\t param:{}",wxSmallProductStandard);

        return ResponseEntity.ok(wxSmallProductStandardService.create(wxSmallProductStandard));
    }

    @PutMapping
    @ApiOperation(value = "根据id更新小程序商品规格")
    @ApiImplicitParam(paramType = "body", name = "wxSmallProductStandard", value = "要更新的小程序商品规格", required = true, dataType = "WxSmallProductStandard")
    public ResponseEntity<Integer> update(@RequestBody WxSmallProductStandard wxSmallProductStandard) {
        log.debug("根据id更新小程序商品规格\t param:{}",wxSmallProductStandard);

        return ResponseEntity.ok(wxSmallProductStandardService.updateById(wxSmallProductStandard));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除小程序商品规格")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除小程序商品规格的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除小程序商品规格\t param:{}",ids);

        return ResponseEntity.ok(wxSmallProductStandardService.deleteByIds(ids));
    }

    @PostMapping("/page/query")
    @ApiOperation(value = "查询小程序商品规格分页列表")
    public ResponseEntity<PagerResultObject<WxSmallProductStandardResult>> pageQuery(WxSmallProductStandard wxSmallProductStandard){
        log.debug("查询小程序商品规格分页列表\t param:{}",wxSmallProductStandard);

        return ResponseEntity.ok(wxSmallProductStandardService.pageList(wxSmallProductStandard));
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

        return ResponseEntity.ok(ArrayObject.of(wxSmallProductStandardService.findGoodsStandards(key, value)));
    }

    @ApiOperation(value = "根据id小程序商品规格信息", notes = "根据id小程序商品规格信息")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<WxSmallProductStandardResult> findProduct(@PathVariable Long id) {

        return ResponseEntity.ok(wxSmallProductStandardService.selectById(id));
    }

}
