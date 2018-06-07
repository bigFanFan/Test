package com.lxs.app.service;

import java.util.Arrays;
import java.util.List;
import com.lxs.app.domain.ProductGroup;
import com.lxs.app.mapper.ProductGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lxs.common.PagerResultObject;

import javax.annotation.Resource;

/**
* Description:商品分类服务类
* @author Limiaojun
* @date 2018/06/07
*/
@Service
@Transactional
public class ProductGroupService {


    @Resource
    private ProductGroupMapper productGroupMapper;

    /**
    * Description:新增商品分类
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    public int create(ProductGroup productGroup){
        return this.productGroupMapper.create(productGroup);
    }

    /** 
    * Description:根据id修改商品分类
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */ 
    public int updateById(ProductGroup productGroup){
        return this.productGroupMapper.updateById(productGroup);
    }

    /** 
    * Description:根据ids删除商品分类
    *  
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */ 
    public int deleteByIds(String ids){
        return this.productGroupMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找商品分类
    *  
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */ 
    public ProductGroup selectById(Long id){
        return this.productGroupMapper.selectById(id);
    }

    /** 
    * Description: 查询商品分类总记录数
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    public long count(ProductGroup productGroup){
        return this.productGroupMapper.pageProductGroupCounts(productGroup);
    }
    
    /** 
    * Description: 查询商品分类分页列表
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    public PagerResultObject<ProductGroup> pageList(ProductGroup productGroup) {
       long total = 0;
       if (productGroup.getRows() != null && productGroup.getRows() > 0) {
           total = this.count(productGroup);
       }
       return PagerResultObject.of(productGroup, total,
              this.productGroupMapper.pageProductGroups(productGroup));
    }
}

