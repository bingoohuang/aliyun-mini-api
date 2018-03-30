package com.github.bingoohuang.aliyun.mini.api.util;

import org.junit.Test;

public class MysqlDbCopyTest {
    @Test(expected = RuntimeException.class)
    public void test() {
        MysqlDbCopy.copyDb(new DbConnectionInfo("host", 3306, "user", "pwd", "db1"),
                new DbConnectionInfo("host", 3306, "user", "pwd", "db2"));
    }
}
