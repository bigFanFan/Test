package com.lhiot.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lhiot.basic.domain.ProductStandardResult;

/**
* 描述：套餐商品关联表服务类
* @author yijun
* @date 2018-07-21
*/
@Mapper
public interface ProductAssortmentRelationMapper {

    //int create(ProductAssortmentRelation productAssortmentRelation);

    //int updateById(ProductAssortmentRelation productAssortmentRelation);

    //int deleteByIds(List<String> ids);

    //List<ProductAssortmentRelation> list(ProductAssortmentRelation productAssortmentRelation);

    //List<ProductAssortmentRelation> page(Map<String,Object> param);

    //int pageQueryCount(Map<String, Object> param);

    //ProductAssortmentRelation findById(Long id);
	
	//根据套餐id查询套餐商品
	List<ProductStandardResult> findProductByAssortmentId(Long assortmentId);
}
