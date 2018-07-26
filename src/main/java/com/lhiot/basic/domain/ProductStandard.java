package com.lhiot.basic.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhiot.basic.common.PagerRequestObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
* Description:商品规格实体类
* @author Limiaojun
* @date 2018/07/20
*/
@Data
@ToString(callSuper = true)
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductStandard extends PagerRequestObject {

    /**
    *规格ID
    */
    @ApiModelProperty(value = "规格ID", dataType = "Long")
    private Long id;

    /**
    *商品ID
    */
    @ApiModelProperty(value = "商品ID", dataType = "Integer")
    private Integer productId;

    /**
    *应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序
    */
    @ApiModelProperty(value = "应用类型:APP-视食 WECHAT_MALL-微商城 S_MALL-小程序", dataType = "String")
    private String applyType;

    /**
    *商品编码
    */
    @ApiModelProperty(value = "商品编码", dataType = "String")
    private String productCode;

    /**
    *商品名称
    */
    @ApiModelProperty(value = "商品名称", dataType = "String")
    private String productName;

    /**
    *分类ID
    */
    @ApiModelProperty(value = "分类ID", dataType = "Long")
    private Long groupId;

    /**
    *产地id
    */
    @ApiModelProperty(value = "产地id", dataType = "String")
    private String sourceCode;

    /**
    *商品主图
    */
    @ApiModelProperty(value = "商品主图", dataType = "String")
    private String image;

    /**
    *商品小图标
    */
    @ApiModelProperty(value = "商品小图标", dataType = "String")
    private String smallImage;

    /**
    *大图标
    */
    @ApiModelProperty(value = "大图标", dataType = "String")
    private String largeImage;

    /**
    *商品状态
    */
    @ApiModelProperty(value = "商品状态", dataType = "String")
    private String status;

    /**
    *基础单位id
    */
    @ApiModelProperty(value = "基础单位id", dataType = "Long")
    private Long baseUnitId;

    /**
    *基础条码
    */
    @ApiModelProperty(value = "基础条码", dataType = "String")
    private String baseBarcode;

    /**
    *海鼎skuid
    */
    @ApiModelProperty(value = "海鼎skuid", dataType = "String")
    private String hdSkuid;

    /**
    *商品介绍视频地址
    */
    @ApiModelProperty(value = "商品介绍视频地址", dataType = "String")
    private String videoUrl;

    /**
    *视频遮罩图片
    */
    @ApiModelProperty(value = "视频遮罩图片", dataType = "String")
    private String videoImage;

    /**
    *基础重量，比如1个0.2kg填写0.2
    */
    @ApiModelProperty(value = "基础重量，比如1个0.2kg填写0.2", dataType = "Double")
    private Double baseQty;

    /**
    *允许销售的最低库存
    */
    @ApiModelProperty(value = "允许销售的最低库存", dataType = "Integer")
    private Integer limitQty;

    /**
    *商品描述
    */
    @ApiModelProperty(value = "商品描述", dataType = "String")
    private String productDescription;

    /**
    *商品条码(hd_skuid)
    */
    @ApiModelProperty(value = "商品条码(hd_skuid)", dataType = "String")
    private String barcode;

    /**
    *商品规格
    */
    @ApiModelProperty(value = "商品规格", dataType = "String")
    private String specification;

    /**
    *商品数量/重量
    */
    @ApiModelProperty(value = "商品数量/重量", dataType = "Double")
    private Double standardQty;

    /**
    *计量单位id
    */
    @ApiModelProperty(value = "计量单位id", dataType = "Integer")
    private Integer unitId;

    /**
    *商品价格
    */
    @ApiModelProperty(value = "商品价格", dataType = "Integer")
    private Integer price;

    /**
    *出售价格
    */
    @ApiModelProperty(value = "出售价格", dataType = "Integer")
    private Integer salePrice;

    /**
    *商品排序
    */
    @ApiModelProperty(value = "商品排序", dataType = "Integer")
    private Integer rank;

    /**
    *规格描述
    */
    @ApiModelProperty(value = "规格描述", dataType = "String")
    private String description;

    /**
    *是否上架 1-上架  0-下架2
    */
    @ApiModelProperty(value = "是否上架 1-上架  0-下架2", dataType = "String")
    private String shelvesStatus;

    /**
     * 商品规格单位
     */
    @ApiModelProperty(value = "商品单位", dataType = "String",hidden = true)
    private String productUnit;

    /**
     * 商品分类名称
     */
    @ApiModelProperty(value = "分类名称", dataType = "String",hidden = true)
    private String groupName;

    /**
     * 商品基础单位
     */
    @ApiModelProperty(value = "商品基础单位", dataType = "String",hidden = true)
    private String baseUnit;

    /**
     * 最小价格
     */
    @JsonIgnore
    @ApiModelProperty(value = "最小价格", dataType = "String")
    private String minPrice;

    /**
     * 最大价格
     */
    @JsonIgnore
    @ApiModelProperty(value = "最大价格", dataType = "String")
    private String maxPrice;

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

}
