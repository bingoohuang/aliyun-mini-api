package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.Req;
import lombok.Value;

import java.util.Map;

@Value
public class DeleteDatabaseReq extends Req {
    private final String dbInstanceId;
    private final String dbName;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "DeleteDatabase");
        m.put("DBInstanceId", dbInstanceId);
        m.put("DBName", dbName);
    }
}
