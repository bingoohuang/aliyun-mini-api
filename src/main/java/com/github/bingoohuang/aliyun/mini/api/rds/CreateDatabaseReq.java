package com.github.bingoohuang.aliyun.mini.api.rds;

import com.github.bingoohuang.aliyun.mini.api.Req;
import lombok.Value;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Value
public class CreateDatabaseReq extends Req {
    private final String dbInstanceId;
    private final String dbName;

    @Override public void populate(Map<String, String> m) {
        m.put("Action", "CreateDatabase");
        m.put("CharacterSetName", "utf8mb4");
        m.put("DBInstanceId", dbInstanceId);
        m.put("DBName", dbName);
        m.put("DBDescription", "aliyun-min-api created at " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
