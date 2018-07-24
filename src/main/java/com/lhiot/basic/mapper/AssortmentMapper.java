package com.lhiot.basic.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lhiot.basic.domain.Assortment;

/**
* 描述：商品套餐服务类
* @author yijun
* @date 2018-07-21
*/
@Mapper
public interface AssortmentMapper {

    //int create(Assortment assortment);

    //int updateById(Assortment assortment);

    //int deleteByIds(List<String> ids);

    //List<Assortment> list(Assortment assortment);

    //List<Assortment> page(Map<String,Object> param);

    //int pageQueryCount(Map<String, Object> param);

    //Assortment findById(Long id);
    
    //根据套餐id的集合查询套餐
    List<Assortment> findByIds(List<Long> list);
}
