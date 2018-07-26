package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.Assortment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* Description:商品套餐Mapper类
* @author yijun
* @date 2018/07/24
*/
@Mapper
public interface AssortmentMapper {

    /**
    * Description:新增商品套餐
    *
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int create(Assortment assortment);

    /**
    * Description:根据id修改商品套餐
    *
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int updateById(Assortment assortment);

    /**
    * Description:根据ids删除商品套餐
    *
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找商品套餐
    *
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    Assortment selectById(Long id);


    /**
     * Description:根据关键字查找商品套餐
     *
     * @param param
     * @return
     * @author yijun
     * @date 2018/07/24 09:55:48
     */
    List<Assortment> findAssortmentByKeywords(Map param);

    /**
    * Description:查询商品套餐列表
    *
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
     List<Assortment> pageAssortments(Assortment assortment);


    /**
    * Description: 查询商品套餐总记录数
    *
    * @param assortment
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    long pageAssortmentCounts(Assortment assortment);
}
