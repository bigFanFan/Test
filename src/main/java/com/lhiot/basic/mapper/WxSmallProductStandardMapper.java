package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.WxSmallProductStandard;
import com.lhiot.basic.domain.out.WxSmallProductStandardResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:小程序商品规格Mapper类
* @author Limiaojun
* @date 2018/06/01
*/
@Mapper
public interface WxSmallProductStandardMapper {

    /**
    * Description:新增小程序商品规格
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    int create(WxSmallProductStandard wxSmallProductStandard);

    /**
    * Description:根据id修改小程序商品规格
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    int updateById(WxSmallProductStandard wxSmallProductStandard);

    /**
    * Description:根据id删除小程序商品规格
    *
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    int deleteByIds(List<String> ids);

    /**
    * Description:查询小程序商品规格列表
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    List<WxSmallProductStandardResult> pageWxSmallProductStandards(WxSmallProductStandard wxSmallProductStandard);

    /**
    * Description: 查询小程序商品规格总记录数
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    long pageWxSmallProductStandardCounts(WxSmallProductStandard wxSmallProductStandard);
}
