package com.lhiot.basic.domain.out;

import com.lhiot.basic.domain.ShelvesStatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description:小程序商品规格实体类
 *
 * @author Limiaojun
 * @date 2018/06/01
 */
@Data
@ToString
@ApiModel
@NoArgsConstructor
@EqualsAndHashCode
public class WxSmallProductStandardResult {

    /**
     * 规格ID
     */
    @ApiModelProperty(notes = "规格ID", dataType = "Long")
    private Long id;

    /**
     * 商品ID
     */
    @ApiModelProperty(notes = "商品ID", dataType = "Long")
    private Long productId;

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
    @ApiModelProperty(notes = "计量单位id", dataType = "Long")
    private Long unitId;

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
     * 商品名称
     */
    @ApiModelProperty(notes = "商品名称", dataType = "String")
    private String productName;

    /**
     * 商品主图
     */
    @ApiModelProperty(notes = "商品主图", dataType = "String")
    private String image;

    /**
     * 商品小图标
     */
    @ApiModelProperty(notes = "商品小图标", dataType = "String")
    private String smallImage;

    /**
     * 大图标
     */
    @ApiModelProperty(notes = "大图标", dataType = "String")
    private String largeImage;

    /**
     * 允许销售的最低库存
     */
    @ApiModelProperty(notes = "允许销售的最低库存", dataType = "Integer")
    private Integer limitQty;

    /**
     * 商品介绍视频地址
     */
    @ApiModelProperty(notes = "商品介绍视频地址", dataType = "String")
    private String videoUrl;

    /**
     * 视频遮罩图片
     */
    @ApiModelProperty(notes = "视频遮罩图片", dataType = "String")
    private String videoImage;

    /**
     * 基础重量，比如1个0.2kg填写0.2
     */
    @ApiModelProperty(notes = "基础重量，比如1个0.2kg填写0.2", dataType = "Double")
    private Double baseQty;

    /**
     * 商品规格描述
     */
    @ApiModelProperty(notes = "商品规格描述", dataType = "String")
    private String productDescription;

    /**
     * 商品规格单位
     */
    @ApiModelProperty(notes = "商品单位", dataType = "String")
    private String productUnit;
    /**
     * 商品编码
     */
    @ApiModelProperty(notes = "商品编码", dataType = "String")
    private String productCode;
    /**
     * 商品分类名称
     */
    @ApiModelProperty(notes = "分类名称", dataType = "String")
    private String groupName;
    /**
     * 商品基础单位
     */
    @ApiModelProperty(notes = "商品基础单位", dataType = "String")
    private String baseUnit;

}
