package com.lhiot.basic.service;

import java.util.Arrays;
import java.util.List;
import com.lhiot.basic.domain.AssortmensectionRelation;
import com.lhiot.basic.domain.Assortment;
import com.lhiot.basic.mapper.AssortmensectionRelationMapper;
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
public class AssortmensectionRelationService {

    private final AssortmensectionRelationMapper assortmensectionRelationMapper;

    @Autowired
    public AssortmensectionRelationService(AssortmensectionRelationMapper assortmensectionRelationMapper) {
        this.assortmensectionRelationMapper = assortmensectionRelationMapper;
    }

    /** 
    * Description:新增板块套餐关联
    *  
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(AssortmensectionRelation assortmensectionRelation){
        return this.assortmensectionRelationMapper.create(assortmensectionRelation);
    }

    /** 
    * Description:根据id修改板块套餐关联
    *  
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(AssortmensectionRelation assortmensectionRelation){
        return this.assortmensectionRelationMapper.updateById(assortmensectionRelation);
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
        return this.assortmensectionRelationMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找板块套餐关联
    *  
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public AssortmensectionRelation selectById(Long id){
        return this.assortmensectionRelationMapper.selectById(id);
    }

    /** 
    * Description: 查询板块套餐关联总记录数
    *  
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(AssortmensectionRelation assortmensectionRelation){
        return this.assortmensectionRelationMapper.pageAssortmensectionRelationCounts(assortmensectionRelation);
    }
    
    /** 
    * Description: 查询板块套餐关联分页列表
    *  
    * @param assortmensectionRelation
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<AssortmensectionRelation> pageList(AssortmensectionRelation assortmensectionRelation) {
       long total = 0;
       if (assortmensectionRelation.getRows() != null && assortmensectionRelation.getRows() > 0) {
           total = this.count(assortmensectionRelation);
       }
       return PagerResultObject.of(assortmensectionRelation, total,
              this.assortmensectionRelationMapper.pageAssortmensectionRelations(assortmensectionRelation));
    }

}

