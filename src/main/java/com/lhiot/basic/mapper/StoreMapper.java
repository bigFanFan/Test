package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:门店Mapper类
* @author Limiaojun
* @date 2018/06/02
*/
@Mapper
public interface StoreMapper {

    /**
    * Description:新增门店
    *
    * @param store
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    int create(Store store);

    /**
    * Description:根据id修改门店
    *
    * @param store
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    int updateById(Store store);

    /**
    * Description:根据ids删除门店
    *
    * @param ids
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    int deleteByIds(List<String> ids);

    /**
    * Description:根据id查找门店
    *
    * @param id
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    Store selectById(Long id);

    /**
    * Description:查询门店列表
    *
    * @param store
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    List<Store> pageStores(Store store);

    /**
    * Description: 查询门店总记录数
    *
    * @param store
    * @return
    * @author Limiaojun
    * @date 2018/06/02 09:04:50
    */
    long pageStoreCounts(Store store);

    /**
     * Description:根据门店ID集合查询门店信息
     *
     * @param storeIds
     * @return
     * @author Limiaojun
     * @date 2018-05-30 12:18
     */
    List<Store> findStoreList(List<String> storeIds);
}
