package ${package_name}.api;

import com.leon.microx.common.wrapper.ApiParamType;
import com.leon.microx.common.wrapper.ArrayObject;
import ${package_name}.domain.${table_name};
import ${package_name}.domain.page.PageReturnObject;
import ${package_name}.service.${table_name}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.sql.Timestamp;


/**
* 描述：${table_annotation}接口类
* @author ${author}
* @date ${date}
*/
@Api(description = "${table_annotation}接口")
@Slf4j
@RestController
@RequestMapping("/${table_name_first_low}")
public class ${table_name}Api {

    private final ${table_name}Service ${table_name_first_low}Service;

    @Autowired
    public ${table_name}Api(${table_name}Service ${table_name_first_low}Service) {
        this.${table_name_first_low}Service = ${table_name_first_low}Service;
    }

    @PostMapping("/create")
    @ApiOperation(value = "${table_annotation}创建")
    public ResponseEntity create(@RequestBody ${table_name} ${table_name_first_low}) {
        return ResponseEntity.ok(${table_name_first_low}Service.create(${table_name_first_low}));
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "依据id更新${table_annotation}")
    public ResponseEntity updateById(@PathVariable("id") Long id,@RequestBody ${table_name} ${table_name_first_low}) {
        ${table_name_first_low}.setId(id);
        return ResponseEntity.ok(${table_name_first_low}Service.updateById(${table_name_first_low}));
    }

    @DeleteMapping("/remove/{ids}")
    @ApiOperation(value = "依据id删除${table_annotation}")
    public ResponseEntity deleteByIds(@PathVariable("ids") String ids) {
        return ResponseEntity.ok(${table_name_first_low}Service.deleteByIds(ids));
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询${table_annotation}列表")
    public ResponseEntity<ArrayObject> list(@RequestBody ${table_name} ${table_name_first_low}){
        return ResponseEntity.ok(ArrayObject.of(${table_name_first_low}Service.list(${table_name_first_low})));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询${table_annotation}列表")
    @ApiImplicitParams({
            <#if model_column?exists>
                <#list model_column as model>
    @ApiImplicitParam(paramType = ApiParamType.QUERY, name = "${model.changeColumnName?uncap_first}", value = "${model.columnComment!}", required = false, dataType = "${model.modelAttrType!}"),
                </#list>
            </#if>
    @ApiImplicitParam(paramType = ApiParamType.QUERY, name = "rows", value = "数据集大小", required = true, dataType = "Integer"),
    @ApiImplicitParam(paramType = ApiParamType.QUERY, name = "page", value = "当前页下标", required = true, dataType = "Integer"),
    @ApiImplicitParam(paramType = ApiParamType.QUERY, name = "sidx", value = "排序字段", required = false, dataType = "String"),
    @ApiImplicitParam(paramType = ApiParamType.QUERY, name = "sord", value = "升序或者降序(asc or desc)", required = false, dataType = "String")
    })
    public ResponseEntity<PageReturnObject> list(
        <#if model_column?exists>
            <#list model_column as model>
    @RequestParam(value="${model.changeColumnName?uncap_first}", required = false) ${model.modelAttrType!} ${model.changeColumnName?uncap_first},
            </#list>
        </#if>
        @RequestParam(value="rows", required = false, defaultValue="10") Integer rows,
        @RequestParam(value="page", required = false, defaultValue="1") Integer page,
        @RequestParam(value="sidx", required = false, defaultValue="") String sidx,
        @RequestParam(value="sord", required = false, defaultValue="") String sord){
        Map<String,Object> param=new HashMap<>();
        <#if model_column?exists>
            <#list model_column as model>
            param.put("${model.changeColumnName?uncap_first}",${model.changeColumnName?uncap_first});
            </#list>
        </#if>
        param.put("page",page);
        param.put("rows",rows);
        param.put("sidx",sidx);
        param.put("sord",sord);

        PageReturnObject result=${table_name_first_low}Service.page(param);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "依据id查询${table_annotation}详细信息")
    public ResponseEntity<${table_name}> find(@PathVariable("id") Long id){
        return ResponseEntity.ok(${table_name_first_low}Service.findById(id));
    }
}
