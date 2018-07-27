package com.lhiot.basic.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.leon.microx.util.ImmutableMap;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.domain.ProductStandardResult;
import com.lhiot.basic.mapper.AssortmentMapper;
import com.lhiot.basic.mapper.ProductAssortmentRelationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:商品套餐服务类
* @author yijun
* @date 2018/07/24
*/
@Service
@Transactional
public class AssortmentService {

    private final AssortmentMapper assortmentMapper;
    private final ProductAssortmentRelationMapper paMapper;
    
    @Autowired
    public AssortmentService(AssortmentMapper assortmentMapper,
    		ProductAssortmentRelationMapper paMapper) {
        this.assortmentMapper = assortmentMapper;
        this.paMapper = paMapper;
    }

    /** 
    * Description:新增商品套餐
    *  
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(Assortment assortment){
        return this.assortmentMapper.create(assortment);
    }

    /** 
    * Description:根据id修改商品套餐
    *  
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(Assortment assortment){
        return this.assortmentMapper.updateById(assortment);
    }

    /** 
    * Description:根据ids删除商品套餐
    *  
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int deleteByIds(String ids){
        return this.assortmentMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找商品套餐
    *  
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public Assortment selectById(Long id){
        return this.assortmentMapper.selectById(id);
    }


    /**
     * Description:根据id查找商品套餐
     *
     * @param keywords
     * @param page
     * @param rows
     * @return
     * @author yijun
     * @date 2018/07/24 09:55:48
     */
    public List<Assortment> findAssortmentByKeywords(String keywords,int page,int rows){
        return this.assortmentMapper.findAssortmentByKeywords(ImmutableMap.of("keywords",keywords,"startRow",page,"rows",rows));
    }


    /** 
    * Description: 查询商品套餐总记录数
    *  
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(Assortment assortment){
        return this.assortmentMapper.pageAssortmentCounts(assortment);
    }
    
    /** 
    * Description: 查询商品套餐分页列表
    *  
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<Assortment> pageList(Assortment assortment) {
       long total = 0;
       if (assortment.getRows() != null && assortment.getRows() > 0) {
           total = this.count(assortment);
       }
       return PagerResultObject.of(assortment, total,
              this.assortmentMapper.pageAssortments(assortment));
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

