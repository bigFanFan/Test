package com.lhiot.basic.domain;

import lombok.Getter;

/**
 * 商品状态枚举
 */
public enum ProductStatusEnum {
    NORMAL("正常"),
    STOP_MINING("停采");


    @Getter
    private String  decription;

    ProductStatusEnum(String decription) {
        this.decription = decription;
    }
}
