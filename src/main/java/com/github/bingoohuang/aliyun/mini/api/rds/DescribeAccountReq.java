package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.base.Req;
import lombok.Value;

import java.util.Map;

@Value
public class DescribeAccountReq extends Req {
    private final String dbInstanceId;
    private final String accountName;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "DescribeAccounts");
        m.put("DBInstanceId", dbInstanceId);
        m.put("AccountName", accountName);
    }
}
