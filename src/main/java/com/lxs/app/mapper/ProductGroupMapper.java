package com.lxs.app.mapper;

import com.lxs.app.domain.ProductGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:商品分类Mapper类
* @author Limiaojun
* @date 2018/06/07
*/
@Mapper
public interface ProductGroupMapper {

    /** 
    * Description:新增商品分类
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    int create(ProductGroup productGroup);
    
    /** 
    * Description:根据id修改商品分类
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    int updateById(ProductGroup productGroup);

    /** 
    * Description:根据ids删除商品分类
    *  
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    int deleteByIds(java.util.List<String> ids);
    
    /** 
    * Description:根据id查找商品分类
    *  
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    ProductGroup selectById(Long id);

    /** 
    * Description:查询商品分类列表
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    List<ProductGroup> pageProductGroups(ProductGroup productGroup);
    
    /** 
    * Description: 查询商品分类总记录数
    *  
    * @param productGroup
    * @return
    * @author Limiaojun
    * @date 2018/06/07 15:46:08
    */  
    long pageProductGroupCounts(ProductGroup productGroup);
}
