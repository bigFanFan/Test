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
* Description:应用类型表(应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序)实体类
* @author yijun
* @date 2018/07/24
*/
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Application extends PagerRequestObject{

    /**
    *
    */
    @JsonProperty("id")
    @ApiModelProperty(value = "", dataType = "Long")
    private Long id;

    /**
    *应用类型描述
    */
    @JsonProperty("description")
    @ApiModelProperty(value = "应用类型描述", dataType = "String")
    private String description;

    /**
    *应用类型名称
    */
    @JsonProperty("applicationName")
    @ApiModelProperty(value = "应用类型名称", dataType = "String")
    private String applicationName;

}
