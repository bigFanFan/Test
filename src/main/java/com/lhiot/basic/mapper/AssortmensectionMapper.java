package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.Assortmensection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* Description:套餐板块分类Mapper类
* @author yijun
* @date 2018/07/24
*/
@Mapper
public interface AssortmensectionMapper {

    /**
    * Description:新增套餐板块分类
    *
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int create(Assortmensection assortmensection);

    /**
    * Description:根据id修改套餐板块分类
    *
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int updateById(Assortmensection assortmensection);

    /**
    * Description:根据ids删除套餐板块分类
    *
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找套餐板块分类
    *
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    Assortmensection selectById(Long id);

    /**
    * Description:查询套餐板块分类列表
    *
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
     List<Assortmensection> pageAssortmensections(Assortmensection assortmensection);


    /**
    * Description: 查询套餐板块分类总记录数
    *
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    long pageAssortmensectionCounts(Assortmensection assortmensection);


    /**
     * 套餐版块查询
     * @param pram
     * @return
     */
    Assortmensection findAssortmentSections(Map pram);
}
