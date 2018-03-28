package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.Req;
import lombok.Value;

import java.util.Map;

@Value
public class DescribeDBInstanceAttributeReq extends Req {
    private final String dbInstanceId;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "DescribeDBInstanceAttribute");
        m.put("DBInstanceId", dbInstanceId);
    }
}
