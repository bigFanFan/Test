package com.lhiot.basic.api;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.service.AssortmentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
* 描述：商品套餐接口类
* @author yijun
* @date 2018-07-21
*/
@Api(description = "商品套餐接口")
@Slf4j
@RestController
@RequestMapping("/assortment")
public class AssortmentApi {

    private final AssortmentService assortmentService;
    
    @Autowired
    public AssortmentApi(AssortmentService assortmentService){
    	this.assortmentService = assortmentService;
    }

    @SuppressWarnings("unchecked")
	@GetMapping("/list/{ids}")
    @ApiOperation(value = "根据ids查找套餐或者套餐及商品列表,供订单服务feign调用")
    public ResponseEntity<ArrayObject<Assortment>> findAssortments(@PathVariable(required=true,value="ids") @NotNull String ids,
    		@RequestParam(required=false,value="flag",defaultValue="no") String flag) {
        log.debug("根据ids查找套餐或者套餐及商品列表", ids);
        return ResponseEntity.ok(ArrayObject.of(assortmentService.findAssortments(ids, flag)));
    }
}
