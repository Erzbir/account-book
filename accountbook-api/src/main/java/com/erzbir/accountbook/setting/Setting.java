package com.erzbir.accountbook.setting;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public interface Setting {
    String getPicDir();

    void setPicDir(String url);

    boolean backup();

    boolean logging();

    void setBackupUrl(String url);

    String getBackupUrl(String url);


    enum LogLevel {
        INFO(1),
        DEBUG(2);

        final int level;

        LogLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }
}
