package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.ProducassortmentRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:套餐商品关联Mapper类
* @author yijun
* @date 2018/07/24
*/
@Mapper
public interface ProducassortmentRelationMapper {

    /**
    * Description:新增套餐商品关联
    *
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int create(ProducassortmentRelation producassortmentRelation);

    /**
    * Description:根据id修改套餐商品关联
    *
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int updateById(ProducassortmentRelation producassortmentRelation);

    /**
    * Description:根据ids删除套餐商品关联
    *
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找套餐商品关联
    *
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    ProducassortmentRelation selectById(Long id);

    /**
    * Description:查询套餐商品关联列表
    *
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
     List<ProducassortmentRelation> pageProducassortmentRelations(ProducassortmentRelation producassortmentRelation);


    /**
    * Description: 查询套餐商品关联总记录数
    *
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    long pageProducassortmentRelationCounts(ProducassortmentRelation producassortmentRelation);
}
