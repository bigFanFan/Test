package com.lhiot.basic.service;

import java.util.Arrays;
import java.util.List;
import com.lhiot.basic.domain.AssortmentSectionRelation;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.mapper.AssortmentSectionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:板块套餐关联服务类
* @author yijun
* @date 2018/07/24
*/
@Service
@Transactional
public class AssortmentSectionRelationService {

    private final AssortmentSectionRelationMapper assortmentSectionRelationMapper;

    @Autowired
    public AssortmentSectionRelationService(AssortmentSectionRelationMapper assortmentSectionRelationMapper) {
        this.assortmentSectionRelationMapper = assortmentSectionRelationMapper;
    }

    /** 
    * Description:新增板块套餐关联
    *  
    * @param assortmentSectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(AssortmentSectionRelation assortmentSectionRelation){
        return this.assortmentSectionRelationMapper.create(assortmentSectionRelation);
    }

    /** 
    * Description:根据id修改板块套餐关联
    *  
    * @param assortmentSectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(AssortmentSectionRelation assortmentSectionRelation){
        return this.assortmentSectionRelationMapper.updateById(assortmentSectionRelation);
    }

    /** 
    * Description:根据ids删除板块套餐关联
    *  
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int deleteByIds(String ids){
        return this.assortmentSectionRelationMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找板块套餐关联
    *  
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public AssortmentSectionRelation selectById(Long id){
        return this.assortmentSectionRelationMapper.selectById(id);
    }

    /** 
    * Description: 查询板块套餐关联总记录数
    *  
    * @param assortmentSectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(AssortmentSectionRelation assortmentSectionRelation){
        return this.assortmentSectionRelationMapper.pageAssortmentSectionRelationCounts(assortmentSectionRelation);
    }
    
    /** 
    * Description: 查询板块套餐关联分页列表
    *  
    * @param assortmentSectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<AssortmentSectionRelation> pageList(AssortmentSectionRelation assortmentSectionRelation) {
       long total = 0;
       if (assortmentSectionRelation.getRows() != null && assortmentSectionRelation.getRows() > 0) {
           total = this.count(assortmentSectionRelation);
       }
       return PagerResultObject.of(assortmentSectionRelation, total,
              this.assortmentSectionRelationMapper.pageAssortmentSectionRelations(assortmentSectionRelation));
    }

}

