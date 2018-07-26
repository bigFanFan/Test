package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.AssortmensectionRelation;
import com.lhiot.basic.domain.Assortment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:板块套餐关联Mapper类
* @author yijun
* @date 2018/07/24
*/
@Mapper
public interface AssortmensectionRelationMapper {

    /**
    * Description:新增板块套餐关联
    *
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int create(AssortmensectionRelation assortmensectionRelation);

    /**
    * Description:根据id修改板块套餐关联
    *
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int updateById(AssortmensectionRelation assortmensectionRelation);

    /**
    * Description:根据ids删除板块套餐关联
    *
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找板块套餐关联
    *
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    AssortmensectionRelation selectById(Long id);

    /**
    * Description:查询板块套餐关联列表
    *
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
     List<AssortmensectionRelation> pageAssortmensectionRelations(AssortmensectionRelation assortmensectionRelation);


    /**
    * Description: 查询板块套餐关联总记录数
    *
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    long pageAssortmensectionRelationCounts(AssortmensectionRelation assortmensectionRelation);


    /**
     * Description:根据套餐板块id查找套餐
     *
     * @param id
     * @return
     * @author yijun
     * @date 2018/07/24 09:55:48
     */
    List<Assortment> findAssortmentByAssortmentSectionId(Long id);
}
