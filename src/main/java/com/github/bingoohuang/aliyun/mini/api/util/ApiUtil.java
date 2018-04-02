package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class ApiUtil {
    public static String createUrl(Map<String, String> m, String accessKeySecret) {
        val canonicalQueryString = buildCanonicalQueryString(m);
        val stringToSign = "GET" + "&" + Url.percentEncode("/") + "&" + Url.percentEncode(canonicalQueryString);
        m.put("Signature", HmacSHA1.hash(stringToSign, accessKeySecret + "&"));
        return Url.createQueryString(m);
    }

    public static String buildCanonicalQueryString(Map<String, String> map) {
        val t = new TreeMap<String, String>(map);
        val q = new StringBuilder();
        for (val e : t.entrySet()) {
            q.append(e.getKey()).append("=").append(Url.percentEncode(e.getValue())).append("&");
        }
        if (!t.isEmpty()) {
            q.delete(q.length() -1, q.length());
        }

        return q.toString();
    }
}
