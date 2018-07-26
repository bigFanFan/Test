package com.lhiot.basic.domain;

import com.lhiot.basic.common.PagerRequestObject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Description:商品套餐实体类
* @author yijun
* @date 2018/07/24
*/
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Assortment extends PagerRequestObject{

    /**
    *
    */
    @JsonProperty("id")
    @ApiModelProperty(value = "", dataType = "Long")
    private Long id;

    /**
    *套餐名称
    */
    @JsonProperty("assortmentName")
    @ApiModelProperty(value = "套餐名称", dataType = "String")
    private String assortmentName;

    /**
    *当前状态(有效- VALID 无效-INVALID)
    */
    @JsonProperty("status")
    @ApiModelProperty(value = "当前状态(有效- VALID 无效-INVALID)", dataType = "String")
    private String status;

    /**
    *创建时间
    */
    @JsonProperty("createTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", dataType = "Date")
    private java.util.Date createTime;
    

    /**
    *创建人
    */
    @JsonProperty("createUser")
    @ApiModelProperty(value = "创建人", dataType = "String")
    private String createUser;

    /**
    *套餐图片
    */
    @JsonProperty("assortmentImage")
    @ApiModelProperty(value = "套餐图片", dataType = "String")
    private String assortmentImage;

    /**
    *套餐详情
    */
    @JsonProperty("detail")
    @ApiModelProperty(value = "套餐详情", dataType = "String")
    private String detail;

    /**
    *套餐简介
    */
    @JsonProperty("introduce")
    @ApiModelProperty(value = "套餐简介", dataType = "String")
    private String introduce;

    /**
    *套餐价格
    */
    @JsonProperty("price")
    @ApiModelProperty(value = "套餐价格", dataType = "Integer")
    private Integer price;

}
