package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class ApiUtil {
    public static String createUrl(Map<String, String> m, String accessKeySecret) {
        val canonicalQueryString = buildCanonicalQueryString(m);
        val stringToSign = buildStringToSign("GET", canonicalQueryString);
        m.put("Signature", HmacSHA1.hash(stringToSign, accessKeySecret + "&"));
        return Url.createQueryString(m);
    }

    public static String buildStringToSign(String httpMethod, String canonicalQueryString) {
        return httpMethod + "&" + Url.percentEncode("/") + "&" + Url.percentEncode(canonicalQueryString);
    }

    public static String buildCanonicalQueryString(Map<String, String> map) {
        val t = new TreeMap<String, String>(map);
        val q = new StringBuilder();
        for (val e : t.entrySet()) {
            q.append(q.length() > 0 ? "&" : "").append(e.getKey()).append("=").append(Url.percentEncode(e.getValue()));
        }

        return q.toString();
    }
}
