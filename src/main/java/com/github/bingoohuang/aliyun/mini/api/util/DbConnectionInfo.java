package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.Value;

@Value
public class DbConnectionInfo {
    private final String host;
    private final int port;
    private final String username;
    private final String password;
    private final String dbName;
}
