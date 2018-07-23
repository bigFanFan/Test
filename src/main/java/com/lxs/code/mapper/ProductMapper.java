package com.lxs.code.mapper;

import com.lxs.code.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:商品信息Mapper类
* @author Limiaojun
* @date 2018/07/23
*/
@Mapper
public interface ProductMapper {

    /**
    * Description:新增商品信息
    *
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
    int create(Product product);

    /**
    * Description:根据id修改商品信息
    *
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
    int updateById(Product product);

    /**
    * Description:根据ids删除商品信息
    *
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找商品信息
    *
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
    Product selectById(Long id);

    /**
    * Description:查询商品信息列表
    *
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
     List<Product> pageProducts(Product product);


    /**
    * Description: 查询商品信息总记录数
    *
    * @param product
    * @return
    * @author Limiaojun
    * @date 2018/07/23 11:15:36
    */
    long pageProductCounts(Product product);
}
