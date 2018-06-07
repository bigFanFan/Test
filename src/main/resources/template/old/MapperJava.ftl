package ${package_name}.mapper;

import ${package_name}.domain.${table_name};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* 描述：${table_annotation}服务类
* @author ${author}
* @date ${date}
*/
@Mapper
public interface ${table_name}Mapper {

    int create(${table_name} ${table_name_first_low});

    int updateById(${table_name} ${table_name_first_low});

    int deleteById(Long id);

    List<${table_name}> list(${table_name} ${table_name_first_low});
}
