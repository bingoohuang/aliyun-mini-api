package com.github.bingoohuang.aliyun.mini.api;

import com.github.bingoohuang.aliyun.mini.api.base.AccessToken;
import com.github.bingoohuang.aliyun.mini.api.util.Str;
import lombok.SneakyThrows;
import org.junit.Test;

public class RdsInstanceTest {
    @Test @SneakyThrows
    public void test() {
        RdsInstance rds = new RdsInstance(new AccessToken("aa", "bb"), "cc");
        rds.describeInstanceAttribute();

        String dbName = Str.random(10, Str.Format.LowerCaseLetters, Str.Format.Digits);
        rds.createDatabase(dbName);

//        while (true) {
//            Thread.sleep(10000);
            /*String result = (String) */rds.describeDatabase(dbName);
//            if (result != null && result.contains("Running")) break;
//        }
        String accountName =  Str.random(10, Str.Format.LowerCaseLetters, Str.Format.Digits, Str.Format.Underscore);

        String accountPassword = Str.random(16);
        rds.createAccount(accountName, accountPassword);

//        while (true) {
//            Thread.sleep(10000);
            /*String result = (String)*/ rds.describeAccount(accountName);
//            if (result != null && result.contains("Available")) break;
//        }

        rds.grantAccountReadWritePrivilege(accountName, dbName);

        rds.deleteDatabase(dbName);
        rds.deleteAccount(accountName);
    }
}

