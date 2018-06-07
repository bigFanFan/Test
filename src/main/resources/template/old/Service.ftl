package ${package_name}.service;

import ${package_name}.domain.${table_name};
import ${package_name}.mapper.${table_name}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：${table_annotation}服务类
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

    public int create(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.create(${table_name_first_low});
    }

    public int updateById(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.updateById(${table_name_first_low});
    }

    public int deleteById(Long id){
        return this.${table_name_first_low}Mapper.deleteById(id);
    }

    public List<${table_name}> list(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.list(${table_name_first_low});
    }

}

