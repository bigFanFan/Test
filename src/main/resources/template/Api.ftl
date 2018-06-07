package ${package_name}.api;

import ${package_name}.domain.${table_name};
import ${package_name}.service.${table_name}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<#if pageFlag>
import ${package_name?substring(0,package_name?last_index_of("."))}.common.PagerResultObject;
<#else>
import java.util.List;
</#if>

/**
* Description:${table_annotation}接口类
* @author ${author}
* @date ${date}
*/
@Api(description = "${table_annotation}接口")
@Slf4j
@RestController
@RequestMapping("/${table_name_small?replace("_","/")}")
public class ${table_name}Api {

    private final ${table_name}Service ${table_name_first_low}Service;

    @Autowired
    public ${table_name}Api(${table_name}Service ${table_name_first_low}Service) {
        this.${table_name_first_low}Service = ${table_name_first_low}Service;
    }

    @PostMapping
    @ApiOperation(value = "添加${table_annotation}")
    @ApiImplicitParam(paramType = "body", name = "${table_name_first_low}", value = "要添加的${table_annotation}", required = true, dataType = "${table_name}")
    public ResponseEntity<Integer> create(@RequestBody ${table_name} ${table_name_first_low}) {
        log.debug("添加${table_annotation}\t param:{}",${table_name_first_low});
        
        return ResponseEntity.ok(${table_name_first_low}Service.create(${table_name_first_low}));
    }

    @PutMapping
    @ApiOperation(value = "根据id更新${table_annotation}")
    @ApiImplicitParam(paramType = "body", name = "${table_name_first_low}", value = "要更新的${table_annotation}", required = true, dataType = "${table_name}")
    public ResponseEntity<Integer> update(@RequestBody ${table_name} ${table_name_first_low}) {
        log.debug("根据id更新${table_annotation}\t param:{}",${table_name_first_low});
        
        return ResponseEntity.ok(${table_name_first_low}Service.updateById(${table_name_first_low}));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除${table_annotation}")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除${table_annotation}的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除${table_annotation}\t param:{}",ids);
        
        return ResponseEntity.ok(${table_name_first_low}Service.deleteByIds(ids));
    }
    
    @ApiOperation(value = "根据id查询${table_annotation}", notes = "根据id查询${table_annotation}")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "${primary_key_modtype}")
    @GetMapping("/{id}")
    public ResponseEntity<${table_name}> find${table_name}(@PathVariable("id") ${primary_key_modtype} id) {

        return ResponseEntity.ok(${table_name_first_low}Service.selectById(id));
    }
    
    <#if pageFlag>
    @PostMapping("/page/query")
    @ApiOperation(value = "查询${table_annotation}分页列表")
    public ResponseEntity<PagerResultObject<${table_name}>> pageQuery(${table_name} ${table_name_first_low}){
        log.debug("查询${table_annotation}分页列表\t param:{}",${table_name_first_low});
        
        return ResponseEntity.ok(${table_name_first_low}Service.pageList(${table_name_first_low}));
    }
    <#else>
    @PostMapping("/list/query")
    @ApiOperation(value = "查询${table_annotation}列表")
    @ApiImplicitParam(paramType = "body", name = "${table_name_first_low}", value = "查询参数", required = true, dataType = "${table_name}")
    public ResponseEntity<List<${table_name}>> listQuery(@RequestBody ${table_name} ${table_name_first_low}){
        log.debug("查询${table_annotation}列表\t param:{}",${table_name_first_low});
        
        return ResponseEntity.ok(${table_name_first_low}Service.list(${table_name_first_low}));
    }
    </#if>
    
}
