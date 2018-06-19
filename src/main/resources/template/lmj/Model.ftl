package ${package_name}.domain;

<#if pageFlag>
import ${package_name?substring(0,package_name?last_index_of("."))}.common.PagerRequestObject;
</#if> 
 
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
    <#if  model.modelAttrType='Timestamp' >
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(notes = "${model.columnComment!}", dataType = "Date" , hidden=true)
    private java.util.Date ${model.changeColumnName?uncap_first};
    
    <#elseif model.modelAttrType='BigDecimal'>
    @ApiModelProperty(notes = "${model.columnComment!}", dataType = "Double")
    private Double ${model.changeColumnName?uncap_first};
    <#else>
    @ApiModelProperty(notes = "${model.columnComment!}", dataType = "${model.modelAttrType!}")
    private ${model.modelAttrType!} ${model.changeColumnName?uncap_first};
    </#if>

    </#list>
</#if>
}
