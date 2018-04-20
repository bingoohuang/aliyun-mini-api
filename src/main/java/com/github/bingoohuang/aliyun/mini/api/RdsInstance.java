package com.github.bingoohuang.aliyun.mini.api;

import com.github.bingoohuang.aliyun.mini.api.base.AccessToken;
import com.github.bingoohuang.aliyun.mini.api.rds.*;

public class RdsInstance {
    private final String dbInstanceId;
    private final Rds rds;

    public RdsInstance(AccessToken accessToken, String dbInstanceId) {
        this.rds = new Rds(accessToken);
        this.dbInstanceId = dbInstanceId;
    }

    public String describeInstanceAttribute() {
        return (String) rds.invoke(new DescribeDBInstanceAttributeReq(dbInstanceId));
    }

    public String createDatabase(String dbName) {
        return (String) rds.invoke(new CreateDatabaseReq(dbInstanceId, dbName));
    }

    public String describeDatabase(String dbName) {
        return (String) rds.invoke(new DescribeDatabasesReq(dbInstanceId, dbName));
    }

    public String describeAllDatabases() {
        return (String) rds.invoke(new DescribeDatabasesReq(dbInstanceId, null));
    }

    public String deleteDatabase(String dbName) {
        return (String) rds.invoke(new DeleteDatabaseReq(dbInstanceId, dbName));
    }

    public String createAccount(String accountName, String accountPassword) {
        return (String) rds.invoke(new CreateAccountReq(dbInstanceId, accountName, accountPassword));
    }

    public String describeAccount(String accountName) {
        return (String) rds.invoke(new DescribeAccountsReq(dbInstanceId, accountName));
    }

    public String describeAllAccounts() {
        return (String) rds.invoke(new DescribeAccountsReq(dbInstanceId, null));
    }

    public String grantAccountPrivilege(String accountName, String dbName, GrantAccountPrivilegeReq.AccountPrivilege accountPrivilege) {
        return (String) rds.invoke(new GrantAccountPrivilegeReq(dbInstanceId, accountName, dbName, accountPrivilege));
    }

    public String deleteAccount(String accountName) {
        return (String) rds.invoke(new DeleteAccountReq(dbInstanceId, accountName));
    }


}
