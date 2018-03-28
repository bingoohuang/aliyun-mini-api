package com.github.bingoohuang.aliyun.mini.api;

import lombok.Value;

@Value
public class AccessToken {
    private final String accessKeyId;
    private final String accessKeySecret;
}
