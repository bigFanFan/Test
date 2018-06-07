package ${package_name}.api;

import com.leon.microx.common.wrapper.ArrayObject;
import ${package_name}.domain.${table_name};
import ${package_name}.service.${table_name}Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping("/remove/{id})")
    @ApiOperation(value = "依据id删除${table_annotation}")
    public ResponseEntity updateById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(${table_name_first_low}Service.deleteById(id));
    }

    @PostMapping("/list")
    @ApiOperation(value = "查询${table_annotation}列表")
    public ResponseEntity<ArrayObject> list(@RequestBody ${table_name} ${table_name_first_low}){
        return ResponseEntity.ok(ArrayObject.of(${table_name_first_low}Service.list(${table_name_first_low})));
    }
}
