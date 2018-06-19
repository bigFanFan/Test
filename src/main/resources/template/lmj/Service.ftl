package ${package_name}.service;

import java.util.Arrays;
import java.util.List;
import ${package_name}.domain.${table_name};
import ${package_name}.mapper.${table_name}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<#if pageFlag>
import ${package_name?substring(0,package_name?last_index_of("."))}.common.PagerResultObject;
</#if>

/**
* Description:${table_annotation}服务类
* @author ${author}
* @date ${date}
*/
@Service
@Transactional
public class ${table_name}Service {

    private final ${table_name}Mapper ${table_name_first_low}Mapper;

    @Autowired
    public ${table_name}Service(${table_name}Mapper ${table_name_first_low}Mapper) {
        this.${table_name_first_low}Mapper = ${table_name_first_low}Mapper;
    }

    /** 
    * Description:新增${table_annotation}
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    public int create(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.create(${table_name_first_low});
    }

    /** 
    * Description:根据id修改${table_annotation}
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */ 
    public int updateById(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.updateById(${table_name_first_low});
    }

    /** 
    * Description:根据ids删除${table_annotation}
    *  
    * @param ids
    * @return
    * @author ${author}
    * @date ${dateTime}
    */ 
    public int deleteByIds(String ids){
        return this.${table_name_first_low}Mapper.deleteByIds(Arrays.asList(ids.split(",")));
    }
    
    /** 
    * Description:根据id查找${table_annotation}
    *  
    * @param id
    * @return
    * @author ${author}
    * @date ${dateTime}
    */ 
    public ${table_name} selectById(${primary_key_modtype} id){
        return this.${table_name_first_low}Mapper.selectById(id);
    }

    <#if pageFlag>
    /** 
    * Description: 查询${table_annotation}总记录数
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    public long count(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.page${table_name}Counts(${table_name_first_low});
    }
    
    /** 
    * Description: 查询${table_annotation}分页列表
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    public PagerResultObject<${table_name}> pageList(${table_name} ${table_name_first_low}) {
       long total = 0;
       if (${table_name_first_low}.getRows() != null && ${table_name_first_low}.getRows() > 0) {
           total = this.count(${table_name_first_low});
       }
       return PagerResultObject.of(${table_name_first_low}, total,
              this.${table_name_first_low}Mapper.page${table_name}s(${table_name_first_low}));
    }
    <#else>
    /** 
    * Description:查询${table_annotation}列表
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */ 
    public List<${table_name}> list(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.list(${table_name_first_low});
    }
    </#if>
}

