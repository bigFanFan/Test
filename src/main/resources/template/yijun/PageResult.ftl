package ${package_name}.domain;

import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* 描述：${table_annotation}
* @author ${author}
* @date ${date}
*/
@ApiModel(description = "${table_annotation}分页查询结果")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${table_name}PageResult extends PageQueryResult{

	@ApiModelProperty(notes = "记录详情", dataType = "List")
        private List<${table_name}Result> array;
    }

