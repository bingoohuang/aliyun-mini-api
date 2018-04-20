package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.base.Req;
import lombok.Value;

import java.util.Map;

@Value
public class DescribeDatabasesReq extends Req {
    private final String dbInstanceId;
    private final String dbName;

    @Override
    public void populate(Map<String, String> m) {
        m.put("Action", "DescribeDatabases");
        m.put("DBInstanceId", dbInstanceId);
        if (dbName != null) m.put("DBName", dbName);
    }
}
