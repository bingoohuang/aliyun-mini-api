package com.github.bingoohuang.aliyun.mini.api;

import lombok.val;
import org.junit.Test;

public class RdsTest {
    @Test
    public void test() {
        val accessKeyId = "accessKeyId";
        val accessKeySecret = "accessKeySecret";
        String dbInstanceId = "dbInstanceId";
        Rds.describeDBInstanceAttribute(accessKeyId, accessKeySecret);
        Rds.describeDatabases(accessKeyId, accessKeySecret, dbInstanceId);
        Rds.grantAccountPrivilege(accessKeyId, accessKeySecret, dbInstanceId, "accountName", "bingooDb");
        Rds.createAccount(accessKeyId, accessKeySecret, dbInstanceId, "accountName", ApiUtil.randomRdsString(16));
        Rds.createDatabase(accessKeyId, accessKeySecret, dbInstanceId, "bingooDb");
    }
}

