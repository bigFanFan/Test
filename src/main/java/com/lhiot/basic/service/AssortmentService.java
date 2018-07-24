package com.lhiot.basic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leon.microx.util.StringUtils;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.domain.ProductStandardResult;
import com.lhiot.basic.mapper.AssortmentMapper;
import com.lhiot.basic.mapper.ProductAssortmentRelationMapper;

/**
* 描述：商品套餐服务类
* @author yijun
* @date 2018-07-21
*/
@Service
@Transactional
public class AssortmentService {

    private final AssortmentMapper assortmentMapper;
    private final ProductAssortmentRelationMapper paMapper;
    
    @Autowired
    public AssortmentService(AssortmentMapper assortmentMapper,ProductAssortmentRelationMapper paMapper) {
        this.assortmentMapper = assortmentMapper;
        this.paMapper = paMapper;
    }

    /**
     * 查询套餐及套餐商品
     * @param ids 套餐id，以逗号分割
     * @param searchProducts 判断是否搜索套餐商品,yes-需要，no-不需要
     * @return
     */
    public List<Assortment> findAssortments(String ids,String searchProducts){
    	List<Long> list = Arrays.asList(ids.split(",")).stream()
    			          .map(id -> Long.parseLong(id.trim())).collect(Collectors.toList());
    	
    	List<Assortment> assortments = assortmentMapper.findByIds(list);
    	if(Objects.isNull(assortments) || assortments.isEmpty()){
    		return null;
    	}
    	//不需要查询套餐商品
    	if("no".equals(searchProducts)){
    		return assortments;
    	}
    	//查询套餐商品
    	for(Assortment assortment : assortments){
    		List<ProductStandardResult> products = paMapper.findProductByAssortmentId(assortment.getId());
    		assortment.setAssortmentProducts(products);
    	}
    	return assortments;
    }
}

