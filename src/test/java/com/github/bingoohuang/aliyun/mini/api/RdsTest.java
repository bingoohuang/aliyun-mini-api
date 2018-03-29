package com.github.bingoohuang.aliyun.mini.api;

import com.github.bingoohuang.aliyun.mini.api.base.AccessToken;
import com.github.bingoohuang.aliyun.mini.api.rds.*;
import com.github.bingoohuang.aliyun.mini.api.util.ApiUtil;
import org.junit.Test;

public class RdsTest {
    @Test
    public void test() {
        Rds rds = new Rds(new AccessToken("accessKeyId", "accessKeySecret"));
        String dbInstanceId = "dbInstanceId";
        rds.invoke(new DescribeDBInstanceAttributeReq(dbInstanceId));
        rds.invoke(new DescribeDatabaseReq(dbInstanceId, "bingooDb"));
        rds.invoke(new DescribeDatabasesReq(dbInstanceId));
        rds.invoke(new GrantAccountPrivilegeReq(dbInstanceId, "accountName", "bingooDb"));
        rds.invoke(new CreateAccountReq(dbInstanceId, "accountName", ApiUtil.randomRdsString(16)));
        rds.invoke(new CreateDatabaseReq(dbInstanceId, "bingooDb"));
        rds.invoke(new DeleteDatabaseReq(dbInstanceId, "bingooDb"));
    }
}

