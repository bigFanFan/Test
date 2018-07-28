package com.lhiot.basic.service;

import com.leon.microx.util.ImmutableMap;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.domain.Assortmensection;
import com.lhiot.basic.mapper.AssortmensectionMapper;
import com.lhiot.basic.mapper.AssortmensectionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
* Description:套餐板块分类服务类
* @author yijun
* @date 2018/07/24
*/
@Service
@Transactional
public class AssortmensectionService {

    private final AssortmensectionMapper assortmensectionMapper;

    private final AssortmensectionRelationMapper assortmensectionRelationMapper;

    @Autowired
    public AssortmensectionService(AssortmensectionMapper assortmensectionMapper, AssortmensectionRelationMapper assortmensectionRelationMapper) {
        this.assortmensectionMapper = assortmensectionMapper;
        this.assortmensectionRelationMapper = assortmensectionRelationMapper;
    }

    /** 
    * Description:新增套餐板块分类
    *  
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(Assortmensection assortmensection){
        return this.assortmensectionMapper.create(assortmensection);
    }

    /** 
    * Description:根据id修改套餐板块分类
    *  
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(Assortmensection assortmensection){
        return this.assortmensectionMapper.updateById(assortmensection);
    }

    /** 
    * Description:根据ids删除套餐板块分类
    *  
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int deleteByIds(String ids){
        return this.assortmensectionMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找套餐板块分类
    *  
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public Assortmensection selectById(Long id){
        return this.assortmensectionMapper.selectById(id);
    }

    /** 
    * Description: 查询套餐板块分类总记录数
    *  
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(Assortmensection assortmensection){
        return this.assortmensectionMapper.pageAssortmensectionCounts(assortmensection);
    }
    
    /** 
    * Description: 查询套餐板块分类分页列表
    *  
    * @param assortmensection
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<Assortmensection> pageList(Assortmensection assortmensection) {
       long total = 0;
       if (assortmensection.getRows() != null && assortmensection.getRows() > 0) {
           total = this.count(assortmensection);
       }
       return PagerResultObject.of(assortmensection, total,
              this.assortmensectionMapper.pageAssortmensections(assortmensection));
    }

    /**
     * Description:套餐版块查询
     *
     * @param nameEn
     * @param applicationType
     * @return
     * @author yijun
     * @date 2018/07/24 09:55:48
     */
    public Assortmensection findAssortmentSections(String nameEn,String applicationType){
        Assortmensection assortmensection=this.assortmensectionMapper.findAssortmentSections(ImmutableMap.of("nameEn",nameEn,"applicationType",applicationType));
        if(assortmensection!=null) {
            //查询套餐商品
            assortmensection.setAssortments(this.assortmensectionRelationMapper.findAssortmentByAssortmentSectionId(assortmensection.getId()));
        }
        return assortmensection;
    }

}

