package ${package_name}.mapper;

import ${package_name}.domain.${table_name};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
* 描述：${table_annotation}服务类
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${table_name}Mapper {

    int create(${table_name} ${table_name_first_low});

    int updateById(${table_name} ${table_name_first_low});

    int deleteByIds(List<String> ids);

    List<${table_name}> list(${table_name} ${table_name_first_low});

    List<${table_name}> page(Map<String,Object> param);

    int pageQueryCount(Map<String, Object> param);

    ${table_name} findById(Long id);
}
