package com.github.bingoohuang.aliyun.mini.api.base;

import lombok.Value;

@Value
public class AccessToken {
    private final String accessKeyId;
    private final String accessKeySecret;
}
