package com.github.bingoohuang.aliyun.mini.api;

import lombok.val;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Rds {
    private final AccessToken accessToken;

    public Rds(AccessToken accessToken) {
        this.accessToken = accessToken;
    }

    public Object invoke(Req req) {
        val m = createCommonParameters();
        req.populate(m);
        return ApiUtil.httpGet(accessToken.getAccessKeySecret(), m, req);
    }

    public Map<String, String> createCommonParameters() {
        val m = new LinkedHashMap<String, String>();
        m.put("Format", "JSON");
        /*
        https://github.com/SkyLothar/requests-aliyun
        [x] OSS (api-version: 2014-08-28)
        [x] ECS (api-version: 2014-05-26)
        [x] RDS (api-version: 2014-08-15)
        [x] SLB (api-version: 2014-05-15)
        [x] CMS (api-version: 2015-04-20)
         */
        m.put("Version", "2014-08-15");
        m.put("AccessKeyId", accessToken.getAccessKeyId());
        m.put("SignatureMethod", "HMAC-SHA1");

        val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));

        m.put("Timestamp", df.format(new Date()));
        m.put("SignatureVersion", "1.0");
        m.put("SignatureNonce", "" + System.currentTimeMillis());

        return m;
    }

}
