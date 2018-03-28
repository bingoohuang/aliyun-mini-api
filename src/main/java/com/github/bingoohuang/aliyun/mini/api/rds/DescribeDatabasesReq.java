package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.Req;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.Map;

@Value @AllArgsConstructor
public class DescribeDatabasesReq extends Req {
    private final String dbInstanceId;

    @Override
    public void populate(Map<String, String> m) {
        m.put("Action", "DescribeDatabases");
        m.put("DBInstanceId", dbInstanceId);
    }
}
