package ${package_name}.service;

import ${package_name}.domain.${table_name};
import ${package_name}.domain.page.PageReturnObject;
import ${package_name}.mapper.${table_name}Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    public int deleteByIds(String ids){
        List<String> idList = Arrays.asList(ids.split(","));
        return this.${table_name_first_low}Mapper.deleteByIds(idList);
    }

    public List<${table_name}> list(${table_name} ${table_name_first_low}){
        return this.${table_name_first_low}Mapper.list(${table_name_first_low});
    }

    public List<${table_name}> page(Map<String,Object> param){
        return this.${table_name_first_low}Mapper.page(param);
    }
    /**
    * 分页查询
    * @return
    */
    public PageReturnObject<${table_name}> page(Map<String,Object> param){
        //查询总记录数
        int total=this.${table_name_first_low}Mapper.pageQueryCount(param);
        //查询分页数据
        //起始行
        int page=Integer.valueOf(String.valueOf(param.get("page")));
        int rows=Integer.valueOf(String.valueOf(param.get("rows")));

        param.put("start",((page-1)*rows));
        //总记录数
        int totalPages = (total%rows==0?total/rows:total/rows+1);
        if(totalPages < page||page<0){
        page = 1;
        param.put("page",page);
        param.put("start",0);
        }
        List<${table_name}> resultList=this.${table_name_first_low}Mapper.page(param);
        return PageReturnObject.of(resultList,totalPages,page,(Objects.nonNull(resultList)?resultList.size():0));
    }


    public ${table_name} findById(Long id){
        return this.${table_name_first_low}Mapper.findById(id);
    }

}

