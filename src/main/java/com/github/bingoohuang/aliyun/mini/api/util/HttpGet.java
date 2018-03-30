package com.github.bingoohuang.aliyun.mini.api.util;

import com.github.bingoohuang.aliyun.mini.api.base.Req;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
public class HttpGet {
    @SneakyThrows
    public static Object httpGet(String url, Req req) {
        log.info("GET URL: {}", url);

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestProperty("Accept-Charset", "UTF-8");
            HttpURLConnection.setFollowRedirects(true);
            con.setConnectTimeout(3000);
            con.setReadTimeout(3000);
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            log.info("Response Code: {}", responseCode);

            val is = responseCode == 200 ? con.getInputStream() : con.getErrorStream();
            val in = new BufferedReader(new InputStreamReader(is));

            val response = new StringBuilder();
            for (String inputLine; (inputLine = in.readLine()) != null; ) {
                response.append(inputLine);
            }

            val responseBody = response.toString();
            log.info("Response Body: {}", responseBody);

            return req.buildRsp(responseCode, responseBody);
        } catch (Exception ex) {
            log.error("GET URL error", ex);
            throw ex;
        } finally {
            if (con != null) con.disconnect();
        }
    }
}
