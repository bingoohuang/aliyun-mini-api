package com.github.bingoohuang.aliyun.mini.api;

import java.util.Map;

public abstract class Req {
    public abstract void populate(Map<String, String> m);

    public Object buildRsp(int responseCode, String responseBody) {
        return responseBody;
    }
}
