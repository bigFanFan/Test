package com.lhiot.basic.domain;

import lombok.Getter;

/**
 * 上架状态枚举
 */
public enum ShelvesStatusEnum {
    VALID("上架"),
    INVALID("下架");


    @Getter
    private String  decription;

    ShelvesStatusEnum(String decription) {
        this.decription = decription;
    }
}
