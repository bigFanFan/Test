package com.lxs.code.domain;

import com.lxs.common.PagerRequestObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Description:商品信息实体类
* @author Limiaojun
* @date 2018/07/23
*/
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends PagerRequestObject{

    /**
    *商品ID
    */
    @JsonProperty("id")
    @ApiModelProperty(value = "商品ID", dataType = "Long")
    private Long id;

    /**
    *商品编码
    */
    @JsonProperty("productCode")
    @ApiModelProperty(value = "商品编码", dataType = "String")
    private String productCode;

    /**
    *商品名称
    */
    @JsonProperty("productName")
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /**
    *分类ID
    */
    @JsonProperty("groupId")
    @ApiModelProperty(value = "分类ID", dataType = "Long")
    private Long groupId;

    /**
    *产地id
    */
    @JsonProperty("sourceCode")
    @ApiModelProperty(value = "产地id", dataType = "String")
    private String sourceCode;

    /**
    *商品主图
    */
    @JsonProperty("image")
    @ApiModelProperty(value = "商品主图", dataType = "String")
    private String image;

    /**
    *商品小图标
    */
    @JsonProperty("smallImage")
    @ApiModelProperty(value = "商品小图标", dataType = "String")
    private String smallImage;

    /**
    *大图标
    */
    @JsonProperty("largeImage")
    @ApiModelProperty(value = "大图标", dataType = "String")
    private String largeImage;

    /**
    *商品状态
    */
    @JsonProperty("status")
    @ApiModelProperty(value = "商品状态", dataType = "String")
    private String status;

    /**
    *基础单位id
    */
    @JsonProperty("unitId")
    @ApiModelProperty(value = "基础单位id", dataType = "Long")
    private Long unitId;

    /**
    *基础条码
    */
    @JsonProperty("baseBarcode")
    @ApiModelProperty(value = "基础条码", dataType = "String")
    private String baseBarcode;

    /**
    *海鼎skuid
    */
    @JsonProperty("hdSkuid")
    @ApiModelProperty(value = "海鼎skuid", dataType = "String")
    private String hdSkuid;

    /**
    *商品介绍视频地址
    */
    @JsonProperty("videoUrl")
    @ApiModelProperty(value = "商品介绍视频地址", dataType = "String")
    private String videoUrl;

    /**
    *视频遮罩图片
    */
    @JsonProperty("videoImage")
    @ApiModelProperty(value = "视频遮罩图片", dataType = "String")
    private String videoImage;

    /**
    *基础重量，比如1个0.2kg填写0.2
    */
    @JsonProperty("baseQty")
    @ApiModelProperty(value = "基础重量，比如1个0.2kg填写0.2", dataType = "Double")
    private Double baseQty;

    /**
    *允许销售的最低库存
    */
    @JsonProperty("limitQty")
    @ApiModelProperty(value = "允许销售的最低库存", dataType = "Integer")
    private Integer limitQty;

    /**
    *商品描述
    */
    @JsonProperty("description")
    @ApiModelProperty(value = "商品描述", dataType = "String")
    private String description;

}
