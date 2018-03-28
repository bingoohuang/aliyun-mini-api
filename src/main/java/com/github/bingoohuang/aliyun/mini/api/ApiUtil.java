package com.github.bingoohuang.aliyun.mini.api;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
public class ApiUtil {
    public static Object httpGet(String accessKeySecret, Map<String, String> m, Req req) {
        val url = ApiUtil.createUrl(m, accessKeySecret);
        return ApiUtil.httpGet(url, req);
    }

    public static String createUrl(Map<String, String> m, String accessKeySecret) {
        val canonicalQueryString = ApiUtil.buildCanonicalQueryString(m);
        val stringToSign = ApiUtil.buildStringToSign("GET", canonicalQueryString);
        val sign = ApiUtil.signString(stringToSign, accessKeySecret + "&");
        m.put("Signature", sign);
        return "https://rds.aliyuncs.com/?" + ApiUtil.createQueryString(m);
    }

    @SneakyThrows
    public static Object httpGet(String url, Req req) {
        log.info("GET URL: {}", url);

        HttpURLConnection con = null;
        try {
            val obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("Accept-Charset", "UTF-8");
            HttpURLConnection.setFollowRedirects(true);
            con.setConnectTimeout(3000);
            con.setReadTimeout(3000);

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            log.info("Response Code: {}", responseCode);

            val is = responseCode == 200 ? con.getInputStream() : con.getErrorStream();
            val in = new BufferedReader(new InputStreamReader(is));
            String inputLine;
            val response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
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

    public static String randomRdsString(int len) {
        val m = new StringBuilder(len);

        val s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";
        val max = s.length();

        val r = new SecureRandom();

        for (int i = 0; i < len; ++i) {
            m.append(s.charAt(r.nextInt(max)));
        }

        return m.toString();
    }

    @SneakyThrows
    public static String signString(String stringToSign, String accessKeySecret) {
        val mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(getBytes(accessKeySecret), "HmacSHA1"));
        val signData = mac.doFinal(getBytes(stringToSign));
        return DatatypeConverter.printBase64Binary(signData);
    }

    @SneakyThrows
    public static byte[] getBytes(String s) {
        return s.getBytes("UTF-8");
    }

    public static String buildStringToSign(String httpMethod, String canonicalQueryString) {
        return httpMethod + "&" + percentEncode("/") + "&" + percentEncode(canonicalQueryString);
    }


    public static String createQueryString(Map<String, String> m) {
        val q = new StringBuilder();

        for (val e : m.entrySet()) {
            q.append(q.length() > 0 ? "&" : "").append(e.getKey()).append("=").append(percentEncode(e.getValue()));
        }
        return q.toString();
    }

    public static String buildCanonicalQueryString(Map<String, String> map) {
        val t = new TreeMap<String, String>(map);
        val q = new StringBuilder();
        for (val e : t.entrySet()) {
            q.append(q.length() > 0 ? "&" : "").append(e.getKey()).append("=").append(percentEncode(e.getValue()));
        }

        return q.toString();
    }

    @SneakyThrows
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
}
