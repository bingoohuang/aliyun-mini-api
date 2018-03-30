package com.github.bingoohuang.aliyun.mini.api.util;

import com.github.bingoohuang.utils.lang.Cmd;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Slf4j
public class MysqlDbCopy {
    /**
     * Copy database content from one db to another.
     */
    public static void copyDb(DbConnectionInfo fromDb, DbConnectionInfo toDb) {
        val dump = new Cmd("sh", "-c",
                "mysqldump -h " + fromDb.getHost() + " -P" + fromDb.getPort() + " -u" + fromDb.getUsername() + " -p" + fromDb.getPassword() + " --opt --default-character-set=utf8 --hex-blob " + fromDb.getDbName() + " --skip-triggers"
                        + " | mysql -h " + toDb.getHost() + " -P" + toDb.getPort() + " -u" + toDb.getUsername() + " -p" + toDb.getPassword() + " -D" + toDb.getDbName());
        val succ = dump.syncExec(1000 * 100);
        if (!succ) {
            log.error("copyDb result: {}, error: {}", succ, dump.getStdErr());
            throw new RuntimeException(dump.getStdErr());
        }
    }
}
