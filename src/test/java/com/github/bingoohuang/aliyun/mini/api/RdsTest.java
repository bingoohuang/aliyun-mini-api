package com.github.bingoohuang.aliyun.mini.api;

import com.github.bingoohuang.aliyun.mini.api.base.AccessToken;
import com.github.bingoohuang.aliyun.mini.api.rds.*;
import com.github.bingoohuang.aliyun.mini.api.util.Str;
import lombok.SneakyThrows;
import org.junit.Test;

public class RdsTest {
    @Test @SneakyThrows
    public void test() {
        Rds rds = new Rds(new AccessToken("aa", "bb"));
        String dbInstanceId = "cc";
        rds.invoke(new DescribeDBInstanceAttributeReq(dbInstanceId));

        String dbName = Str.random(10, Str.Format.LowerCaseLetters, Str.Format.Digits);
        rds.invoke(new CreateDatabaseReq(dbInstanceId, dbName));

//        while (true) {
//            Thread.sleep(10000);
            /*String result = (String) */rds.invoke(new DescribeDatabaseReq(dbInstanceId, dbName));
//            if (result != null && result.contains("Running")) break;
//        }
        String accountName =  Str.random(10, Str.Format.LowerCaseLetters, Str.Format.Digits, Str.Format.Underscore);

        String accountPassword = Str.random(16);
        rds.invoke(new CreateAccountReq(dbInstanceId, accountName, accountPassword));

//        while (true) {
//            Thread.sleep(10000);
            /*String result = (String)*/ rds.invoke(new DescribeAccountReq(dbInstanceId, accountName));
//            if (result != null && result.contains("Available")) break;
//        }

        rds.invoke(new GrantAccountPrivilegeReq(dbInstanceId, accountName, dbName));

        rds.invoke(new DeleteDatabaseReq(dbInstanceId, dbName));
        rds.invoke(new DeleteAccountReq(dbInstanceId, accountName));
    }
}

