package com.lhiot.basic.mapper;

import com.lhiot.basic.domain.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)Mapper类
* @author yijun
* @date 2018/07/24
*/
@Mapper
public interface ApplicationMapper {

    /**
    * Description:新增应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int create(Application application);

    /**
    * Description:根据id修改应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int updateById(Application application);

    /**
    * Description:根据ids删除应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    int deleteByIds(java.util.List<String> ids);

    /**
    * Description:根据id查找应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *
    * @param id
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    Application selectById(Long id);

    /**
    * Description:查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)列表
    *
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
     List<Application> pageApplications(Application application);


    /**
    * Description: 查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)总记录数
    *
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */
    long pageApplicationCounts(Application application);
}
