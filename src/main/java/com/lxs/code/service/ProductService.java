package com.lxs.code.service;

import java.util.Arrays;
import java.util.List;
import com.lxs.code.domain.Product;
import com.lxs.code.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lxs.common.PagerResultObject;

/**
* Description:商品信息服务类
* @author Limiaojun
* @date 2018/07/23
*/
@Service
@Transactional
public class ProductService {

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    /** 
    * Description:新增商品信息
    *  
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */  
    public int create(Product product){
        return this.productMapper.create(product);
    }

    /** 
    * Description:根据id修改商品信息
    *  
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */ 
    public int updateById(Product product){
        return this.productMapper.updateById(product);
    }

    /** 
    * Description:根据ids删除商品信息
    *  
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */ 
    public int deleteByIds(String ids){
        return this.productMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找商品信息
    *  
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */ 
    public Product selectById(Long id){
        return this.productMapper.selectById(id);
    }

    /** 
    * Description: 查询商品信息总记录数
    *  
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */  
    public long count(Product product){
        return this.productMapper.pageProductCounts(product);
    }
    
    /** 
    * Description: 查询商品信息分页列表
    *  
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */  
    public PagerResultObject<Product> pageList(Product product) {
       long total = 0;
       if (product.getRows() != null && product.getRows() > 0) {
           total = this.count(product);
       }
       return PagerResultObject.of(product, total,
              this.productMapper.pageProducts(product));
    }
}

