package com.lhiot.basic.service;

import java.util.Arrays;
import java.util.List;
import com.lhiot.basic.domain.ProducassortmentRelation;
import com.lhiot.basic.mapper.ProducassortmentRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:套餐商品关联服务类
* @author yijun
* @date 2018/07/24
*/
@Service
@Transactional
public class ProducassortmentRelationService {

    private final ProducassortmentRelationMapper producassortmentRelationMapper;

    @Autowired
    public ProducassortmentRelationService(ProducassortmentRelationMapper producassortmentRelationMapper) {
        this.producassortmentRelationMapper = producassortmentRelationMapper;
    }

    /** 
    * Description:新增套餐商品关联
    *  
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(ProducassortmentRelation producassortmentRelation){
        return this.producassortmentRelationMapper.create(producassortmentRelation);
    }

    /** 
    * Description:根据id修改套餐商品关联
    *  
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(ProducassortmentRelation producassortmentRelation){
        return this.producassortmentRelationMapper.updateById(producassortmentRelation);
    }

    /** 
    * Description:根据ids删除套餐商品关联
    *  
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int deleteByIds(String ids){
        return this.producassortmentRelationMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找套餐商品关联
    *  
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public ProducassortmentRelation selectById(Long id){
        return this.producassortmentRelationMapper.selectById(id);
    }

    /** 
    * Description: 查询套餐商品关联总记录数
    *  
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(ProducassortmentRelation producassortmentRelation){
        return this.producassortmentRelationMapper.pageProducassortmentRelationCounts(producassortmentRelation);
    }
    
    /** 
    * Description: 查询套餐商品关联分页列表
    *  
    * @param producassortmentRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<ProducassortmentRelation> pageList(ProducassortmentRelation producassortmentRelation) {
       long total = 0;
       if (producassortmentRelation.getRows() != null && producassortmentRelation.getRows() > 0) {
           total = this.count(producassortmentRelation);
       }
       return PagerResultObject.of(producassortmentRelation, total,
              this.producassortmentRelationMapper.pageProducassortmentRelations(producassortmentRelation));
    }
}

