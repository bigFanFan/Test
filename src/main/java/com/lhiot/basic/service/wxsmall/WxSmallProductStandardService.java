package com.lhiot.basic.service.wxsmall;

import com.lhiot.basic.domain.WxSmallProductStandard;
import com.lhiot.basic.domain.out.WxSmallProductStandardResult;
import com.lhiot.basic.mapper.WxSmallProductStandardMapper;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.common.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
* Description:小程序商品规格服务类
* @author Limiaojun
* @date 2018/06/01
*/
@Service
@Transactional
public class WxSmallProductStandardService {

    private final WxSmallProductStandardMapper wxSmallProductStandardMapper;

    @Autowired
    public WxSmallProductStandardService(WxSmallProductStandardMapper wxSmallProductStandardMapper) {
        this.wxSmallProductStandardMapper = wxSmallProductStandardMapper;
    }

    /**
    * Description:新增小程序商品规格
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    public int create(WxSmallProductStandard wxSmallProductStandard){
        return this.wxSmallProductStandardMapper.create(wxSmallProductStandard);
    }

    /**
    * Description:根据id修改小程序商品规格
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    public int updateById(WxSmallProductStandard wxSmallProductStandard){
        return this.wxSmallProductStandardMapper.updateById(wxSmallProductStandard);
    }

    /**
    * Description:根据id删除小程序商品规格
    *
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    public int deleteByIds(String ids){
        return this.wxSmallProductStandardMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }

    /**
    * Description: 查询小程序商品规格总记录数
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    public long count(WxSmallProductStandard wxSmallProductStandard){
        return this.wxSmallProductStandardMapper.pageWxSmallProductStandardCounts(wxSmallProductStandard);
    }

    /**
    * Description: 查询小程序商品规格分页列表
    *
    * @param wxSmallProductStandard
    * @return
    * @author Limiaojun
    * @date 2018/06/01 17:46:50
    */
    public PagerResultObject<WxSmallProductStandardResult> pageList(WxSmallProductStandard wxSmallProductStandard) {
        long total = 0;
        if (wxSmallProductStandard.getRows() != null && wxSmallProductStandard.getRows() > 0) {
            total = this.count(wxSmallProductStandard);
        }
        return PagerResultObject.of(wxSmallProductStandard, total,
               this.wxSmallProductStandardMapper.pageWxSmallProductStandards(wxSmallProductStandard));
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
    public List<WxSmallProductStandardResult> findGoodsStandards(String key, String value) {

        WxSmallProductStandard param = new WxSmallProductStandard();
        param.setRows(null);
        param.setFlag(true);

        if ("ids".equals(key)) {
            param.setIds(Arrays.asList(value.split(",")));
        } else {
            param.setBarcode(value.trim());
        }

        return this.wxSmallProductStandardMapper.pageWxSmallProductStandards(param);
    }

    /**
     * Description:根据id小程序商品规格信息
     *
     * @param id
     * @return
     * @author Limiaojun
     * @date 2018-06-01 20:16
     */
    public WxSmallProductStandardResult selectById(Long id) {
        WxSmallProductStandard param = new WxSmallProductStandard();
        param.setRows(null);
        param.setId(id);

        return (WxSmallProductStandardResult) CommonUtils.getCollectionsFirst(this.wxSmallProductStandardMapper.pageWxSmallProductStandards(param));
    }
}

