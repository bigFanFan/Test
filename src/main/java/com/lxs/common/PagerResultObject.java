/**   
* @Title: Pager.java 
* @Package cn.analysys.data.mobitor.manager.model 
* @Description: 
* @author LiMiaojun
* @date 2017年7月17日 上午10:59:45 
* @version V1.0   
*/
package com.lxs.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/** 
 * Description: 分页返回对象
 *
 * @author Limiaojun
 * @date: 2018-04-23 10:31:27
 * @version 1.0
 * @since JDK 1.8
 */
@Data
public class PagerResultObject<T> {

    @ApiModelProperty(notes = "当前页")
    private Long page;

    @ApiModelProperty(notes = "总记录数")
    private Long total;

    @ApiModelProperty(notes = "返回行数,每页显示条数")
    private Long records;
    
    @ApiModelProperty(notes = "总分页数")
    private Long allPages;
    
    @ApiModelProperty(notes = "数据")
    private List<T> rows = Collections.emptyList();
    
    /** 
     * Description:构建分页对象
     *  
     * @param pageObj      分页请求参数对象
     * @param total     总记录数
     * @param rows      返回list对象
     * @return
     * @author Limiaojun
     * @date 2018-05-31 09:27
     */  
    public static <T> PagerResultObject<T> of(Object pageObj, Long total, List<T> rows) {
        PagerResultObject<T> pagerResultObject = new PagerResultObject<T>();
        // 返回记录条数
        long records = 0;
        // 当前页
        long page = 0;
        if (pageObj instanceof PagerRequestObject) {
            PagerRequestObject pager = (PagerRequestObject) pageObj;
            if (pager.getPage() != null)
                page = pager.getPage();
            if (pager.getRows() != null)
                records = pager.getRows();
        }
        if (pageObj instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> pager = (Map<String, Object>) pageObj;
            page = (long) pager.getOrDefault("page",0);
            records = (long) pager.getOrDefault("rows",0);
        }
        if (records > 0) {
            pagerResultObject.setPage(page);
            pagerResultObject.setRecords(records);
            pagerResultObject.setTotal(total);
            pagerResultObject.setAllPages(total % records == 0 ? total / records : total / records + 1);
        }
        pagerResultObject.setRows(rows);

        return pagerResultObject;
    }

    /**
     * Description:app-admin 总分页参数为total  ,需要处理
     *
     * @return
     * @author Limiaojun
     * @date 2018-04-23 11:44
     */
    public Long getTotal() {

        return allPages;
    }
}
