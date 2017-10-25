package com.bbd.dafei.common.modal.util;

import com.bbd.dafei.common.util.PageInfo;

/**
 * Created by wish on 2017/5/24.
 */
public interface Dialect {

    enum Type {
        MYSQL {
            public String getValue() {
                return "mysql";
            }
        },
        ORACLE {
            public String getValue() {
                return "oracle";
            }
        }
    }

    String getPageSql(String sql, PageInfo page);
}
