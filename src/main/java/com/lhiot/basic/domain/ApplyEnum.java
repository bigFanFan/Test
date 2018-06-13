package com.lhiot.basic.domain;

import lombok.Getter;

public enum ApplyEnum {
    APP("视食"),
    WECHAT_MALL("微商城"),
    S_MALL("小程序");

    @Getter
    private String description;

    ApplyEnum(String description) {
        this.description = description;
    }
}
