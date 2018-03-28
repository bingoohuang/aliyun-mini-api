package com.github.bingoohuang.aliyun.mini.api;

import lombok.val;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Rds {
    public static String describeDatabases(String accessKeyId, String accessKeySecret, String dbInstanceId) {
        val m = Rds.createCommonParameters(accessKeyId);
        describeDatabases(m, dbInstanceId);
        return ApiUtil.httpGet(accessKeySecret, m);
    }

    private static void describeDatabases(Map<String, String> m, String dbInstanceId) {
        m.put("Action", "DescribeDatabases");
        m.put("DBInstanceId", dbInstanceId);
    }

    public static String grantAccountPrivilege(String accessKeyId, String accessKeySecret, String dbInstanceId, String accountName, String dbName) {
        val m = Rds.createCommonParameters(accessKeyId);
        grantAccountPrivilege(m, dbInstanceId, accountName, dbName);
        return ApiUtil.httpGet(accessKeySecret, m);
    }

    private static void grantAccountPrivilege(Map<String, String> m, String dbInstanceId, String accountName, String dbName) {
        m.put("Action", "GrantAccountPrivilege");
        m.put("DBInstanceId", dbInstanceId);
        m.put("AccountName", accountName);
        m.put("DBName", dbName);
        m.put("AccountPrivilege", "ReadWrite");
    }

    public static String createAccount(String accessKeyId, String accessKeySecret, String dbInstanceId, String accountName, String accountPassword) {
        val m = Rds.createCommonParameters(accessKeyId);
        createAccount(m, dbInstanceId, accountName, accountPassword);
        return ApiUtil.httpGet(accessKeySecret, m);
    }

    private static void createAccount(Map<String, String> m, String dbInstanceId, String accountName, String accountPassword) {
        m.put("Action", "CreateAccount");
        m.put("DBInstanceId", dbInstanceId);
        m.put("AccountName", accountName);
        m.put("AccountPassword", accountPassword);
    }

    public static String createDatabase(String accessKeyId, String accessKeySecret, String dbInstanceId, String dbName) {
        val m = Rds.createCommonParameters(accessKeyId);
        createDatabase(m, dbInstanceId, dbName);
        return ApiUtil.httpGet(accessKeySecret, m);
    }

    private static void createDatabase(Map<String, String> m, String dbInstanceId, String dbName) {
        m.put("Action", "CreateDatabase");
        m.put("CharacterSetName", "utf8mb4");
        m.put("DBInstanceId", dbInstanceId);
        m.put("DBName", dbName);
        m.put("DBDescription", "aliyun-min-api created at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    public static String describeDBInstanceAttribute(String accessKeyId, String accessKeySecret) {
        val m = Rds.createCommonParameters(accessKeyId);
        describeDBInstanceAttribute(m);
        return ApiUtil.httpGet(accessKeySecret, m);
    }

    private static void describeDBInstanceAttribute(Map<String, String> m) {
        m.put("Action", "DescribeDBInstanceAttribute");
        m.put("DBInstanceId", "rds8u95ewkz4x0h461em");
    }

    public static LinkedHashMap<String, String> createCommonParameters(String accessKeyId) {
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
        m.put("AccessKeyId", accessKeyId);
        m.put("SignatureMethod", "HMAC-SHA1");

        val df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));

        m.put("Timestamp", df.format(new Date()));
        m.put("SignatureVersion", "1.0");
        m.put("SignatureNonce", "" + System.currentTimeMillis());

        return m;
    }

}
