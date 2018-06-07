package ${package_name}.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
* 描述：${table_annotation}
* @author ${author}
* @date ${date}
*/
@Data
@ToString
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${table_name} {

<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
    @JsonProperty("${model.changeColumnName?uncap_first}")
    <#if  model.modelAttrType='Timestamp' >
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    </#if>
    @ApiModelProperty(notes = "${model.columnComment!}", dataType = "${model.modelAttrType!}")
    private ${model.modelAttrType!} ${model.changeColumnName?uncap_first};

    </#list>
</#if>
}
