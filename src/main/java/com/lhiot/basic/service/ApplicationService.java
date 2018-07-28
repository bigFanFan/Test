package com.lhiot.basic.service;

import java.util.Arrays;
import java.util.List;
import com.lhiot.basic.domain.Application;
import com.lhiot.basic.mapper.ApplicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lhiot.basic.common.PagerResultObject;

/**
* Description:应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)服务类
* @author yijun
* @date 2018/07/24
*/
@Service
@Transactional
public class ApplicationService {

    private final ApplicationMapper applicationMapper;

    @Autowired
    public ApplicationService(ApplicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    /** 
    * Description:新增应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *  
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public int create(Application application){
        return this.applicationMapper.create(application);
    }

    /** 
    * Description:根据id修改应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *  
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public int updateById(Application application){
        return this.applicationMapper.updateById(application);
    }

    /** 
    * Description:根据ids删除应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *  
    * @param ids
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
/*    public int deleteByIds(String ids){
        return this.applicationMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }*/
    
    /** 
    * Description:根据id查找应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)
    *  
    * @param applicationName
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */ 
    public Application selectById(String applicationName){
        return this.applicationMapper.selectById(applicationName);
    }

    /** 
    * Description: 查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)总记录数
    *  
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public long count(Application application){
        return this.applicationMapper.pageApplicationCounts(application);
    }
    
    /** 
    * Description: 查询应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)分页列表
    *  
    * @param application
    * @return
    * @author yijun
    * @date 2018/07/24 09:55:48
    */  
    public PagerResultObject<Application> pageList(Application application) {
       long total = 0;
       if (application.getRows() != null && application.getRows() > 0) {
           total = this.count(application);
       }
       return PagerResultObject.of(application, total,
              this.applicationMapper.pageApplications(application));
    }
}

