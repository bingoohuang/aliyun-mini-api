package com.github.bingoohuang.aliyun.mini.api.util;

import lombok.SneakyThrows;
import lombok.val;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class HmacSHA1 {
    @SneakyThrows
    public static String hash(String s, String key) {
        val mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(Str.utf8Bytes(key), "HmacSHA1"));
        val signData = mac.doFinal(Str.utf8Bytes(s));
        return DatatypeConverter.printBase64Binary(signData);
    }
}
