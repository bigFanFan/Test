package com.lhiot.basic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhiot.basic.common.PagerRequestObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Description:小程序商品规格实体类
 *
 * @author Limiaojun
 * @date 2018/06/01
 */
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WxSmallProductStandard extends PagerRequestObject {

    /**
     * 规格ID
     */
    @Min(value= 18 ,message= "必须年满18岁！" )
    @ApiModelProperty(notes = "规格ID", dataType = "Long")
    private Long id;

    /**
     * 商品ID
     */
    @ApiModelProperty(notes = "商品ID", dataType = "Integer")
    private Integer productId;

    /**
     * 商品条码(hd_skuid)
     */
    @ApiModelProperty(notes = "商品条码(hd_skuid)", dataType = "String")
    private String barcode;

    /**
     * 商品规格
     */
    @ApiModelProperty(notes = "商品规格", dataType = "String")
    private String specification;

    /**
     * 商品数量/重量
     */
    @ApiModelProperty(notes = "商品数量/重量", dataType = "Double")
    private Double standardQty;

    /**
     * 计量单位id
     */
    @ApiModelProperty(notes = "计量单位id", dataType = "Integer")
    private Integer unitId;

    /**
     * 商品价格
     */
    @ApiModelProperty(notes = "商品价格", dataType = "Integer")
    private Integer price;

    /**
     * 出售价格
     */
    @ApiModelProperty(notes = "出售价格", dataType = "Integer")
    private Integer salePrice;

    /**
     * 商品排序
     */
    @ApiModelProperty(notes = "商品排序", dataType = "Integer")
    private Integer rank;

    /**
     * 规格描述
     */
    @ApiModelProperty(notes = "规格描述", dataType = "String")
    private String description;

    /**
     * 是否上架 VALID("上架"), INVALID("下架")
     */
    @ApiModelProperty(notes = "VALID(\"上架\"), INVALID(\"下架\");", dataType = "ShelvesStatusEnum")
    private ShelvesStatusEnum shelvesStatus;

    /**
     * 根据规格ids和barcode匹配 -标识位 条件查询参数,不返回
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private boolean flag;

    /**
     * 规格ids集合 条件查询参数,不返回
     */
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private List<String> ids;

    /**
     * 商品名称 条件查询参数,不返回
     */
    @JsonIgnore
    @ApiModelProperty(notes = "商品名称", dataType = "String")
    private String productName;

    /**
     * 商品名称 条件查询参数,不返回
     */
    @JsonIgnore
    @ApiModelProperty(notes = "商品编码", dataType = "String")
    private String productCode;

    /**
     * 最小价格
     */
    @JsonIgnore
    @ApiModelProperty(notes = "最小价格", dataType = "String")
    private String minPrice;

    /**
     * 最大价格
     */
    @JsonIgnore
    @ApiModelProperty(notes = "最大价格", dataType = "String")
    private String maxPrice;

}
