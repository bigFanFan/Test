package com.lhiot.basic.service;

import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.common.util.CommonUtils;
import com.lhiot.basic.domain.ProductStandard;
import com.lhiot.basic.domain.WxSmallProductStandard;
import com.lhiot.basic.domain.out.WxSmallProductStandardResult;
import com.lhiot.basic.mapper.ProducStandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
* Description:商品规格服务类
* @author Limiaojun
* @date 2018/07/20
*/
@Service
@Transactional
public class ProducStandardService {

    private final ProducStandardMapper producstandardMapper;

    @Autowired
    public ProducStandardService(ProducStandardMapper producstandardMapper) {
        this.producstandardMapper = producstandardMapper;
    }

    /** 
    * Description:新增商品规格
    *  
    * @param producstandard
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */  
    public int create(ProductStandard producstandard){
        return this.producstandardMapper.create(producstandard);
    }

    /** 
    * Description:根据id修改商品规格
    *  
    * @param producstandard
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */ 
    public int updateById(ProductStandard producstandard){
        return this.producstandardMapper.updateById(producstandard);
    }

    /** 
    * Description:根据ids删除商品规格
    *  
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */ 
    public int deleteByIds(String ids){
        return this.producstandardMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找商品规格
    *  
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */ 
    public ProductStandard selectById(Long id){
//        return this.producstandardMapper.selectById(id);
        ProductStandard param = new ProductStandard();
        param.setRows(null);
        param.setId(id);

        return (ProductStandard) CommonUtils.getCollectionsFirst(this.producstandardMapper.pageProducstandards(param));
    }

    /** 
    * Description: 查询商品规格总记录数
    *  
    * @param producstandard
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */  
    public long count(ProductStandard producstandard){
        return this.producstandardMapper.pageProducstandardCounts(producstandard);
    }
    
    /** 
    * Description: 查询商品规格分页列表
    *  
    * @param producstandard
    * @return
    * @author Limiaojun
    * @date 2018/07/20 15:33:33
    */  
    public PagerResultObject<ProductStandard> pageList(ProductStandard producstandard) {
       long total = 0;
       if (producstandard.getRows() != null && producstandard.getRows() > 0) {
           total = this.count(producstandard);
       }
       return PagerResultObject.of(producstandard, total,
              this.producstandardMapper.pageProducstandards(producstandard));
    }



    /**
     * Description:根据规格ids,或者barcode查找
     *
     * @param key
     * @param value
     * @return
     * @author Limiaojun
     * @date 2018-05-30 19:44
     */
    public List<ProductStandard> findGoodsStandards(String key, String value) {

        ProductStandard param = new ProductStandard();
        param.setRows(null);
        param.setFlag(true);

        if ("ids".equals(key)) {
            param.setIds(Arrays.asList(value.split(",")));
        } else {
            param.setBarcode(value.trim());
        }

        return this.producstandardMapper.pageProducstandards(param);
    }
}

