package ${package_name}.domain;

<#if pageFlag>
import ${package_name?substring(0,package_name?last_index_of("."))}.common.PagerRequestObject;
</#if> 

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Description:${table_annotation}
* @author ${author}
* @date ${date}
*/
@Data
@ToString<#if pageFlag>(callSuper = true)</#if>
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode<#if pageFlag>(callSuper = true)</#if>
public class ${table_name} <#if pageFlag>extends PagerRequestObject</#if>{

<#if model_column?exists>
    <#list model_column as model>
    /**
    *${model.columnComment!}
    */
    @JsonProperty("${model.changeColumnName?uncap_first}")
    <#if  model.modelAttrType='Timestamp' >
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "${model.columnComment!}", dataType = "Date")
    private java.util.Date ${model.changeColumnName?uncap_first};
    
    <#elseif model.modelAttrType='BigDecimal'>
    @ApiModelProperty(value = "${model.columnComment!}", dataType = "Double")
    private Double ${model.changeColumnName?uncap_first};
    <#else>
    @ApiModelProperty(value = "${model.columnComment!?replace("\"","")}", dataType = "${model.modelAttrType!}")
    private ${model.modelAttrType!} ${model.changeColumnName?uncap_first};
    </#if>

    </#list>
</#if>
}
