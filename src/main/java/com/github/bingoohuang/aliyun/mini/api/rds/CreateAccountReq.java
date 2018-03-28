package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.Req;
import lombok.Value;

import java.util.Map;

@Value
public class CreateAccountReq extends Req {
    private final String dbInstanceId;
    private final String accountName;
    private final String accountPassword;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "CreateAccount");
        m.put("DBInstanceId", dbInstanceId);
        m.put("AccountName", accountName);
        m.put("AccountPassword", accountPassword);
    }
}
