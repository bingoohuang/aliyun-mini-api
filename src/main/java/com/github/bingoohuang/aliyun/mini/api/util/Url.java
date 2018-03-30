package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.SneakyThrows;
import lombok.val;

import java.net.URLEncoder;
import java.util.Map;

public class Url {
    public static String percentEncode(String value) {
        return urlEncode(value)
                .replace("+", "%20")
                .replace("*", "%2A")
                .replace("%7E", "~");
    }

    @SneakyThrows
    public static String urlEncode(String s) {
        return URLEncoder.encode(s, "UTF-8");
    }

    public static String createQueryString(Map<String, String> m) {
        val q = new StringBuilder();

        for (val e : m.entrySet()) {
            q.append(q.length() > 0 ? "&" : "").append(e.getKey()).append("=").append(percentEncode(e.getValue()));
        }
        return q.toString();
    }
}
