package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.base.Req;
import lombok.Value;

import java.util.Map;

@Value
public class GrantAccountReadWritePrivilegeReq extends Req {
    private final String dbInstanceId;
    private final String accountName;
    private final String dbName;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "GrantAccountPrivilege");
        m.put("DBInstanceId", dbInstanceId);
        m.put("AccountName", accountName);
        m.put("DBName", dbName);
        m.put("AccountPrivilege", "ReadWrite");
    }
}