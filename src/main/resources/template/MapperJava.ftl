package ${package_name}.mapper;

import ${package_name}.domain.${table_name};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* Description:${table_annotation}Mapper类
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${table_name}Mapper {

    /** 
    * Description:新增${table_annotation}
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    int create(${table_name} ${table_name_first_low});
    
    /** 
    * Description:根据id修改${table_annotation}
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    int updateById(${table_name} ${table_name_first_low});

    /** 
    * Description:根据ids删除${table_annotation}
    *  
    * @param ids
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    int deleteByIds(java.util.List<String> ids);
    
    /** 
    * Description:根据id查找${table_annotation}
    *  
    * @param id
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    ${table_name} selectById(${primary_key_modtype} id);

    /** 
    * Description:查询${table_annotation}列表
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    List<${table_name}> page${table_name}s(${table_name} ${table_name_first_low});
    
    /** 
    * Description: 查询${table_annotation}总记录数
    *  
    * @param ${table_name_first_low}
    * @return
    * @author ${author}
    * @date ${dateTime}
    */  
    long page${table_name}Counts(${table_name} ${table_name_first_low});
}
