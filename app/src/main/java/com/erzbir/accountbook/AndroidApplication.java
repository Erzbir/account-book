package com.erzbir.accountbook;

import android.app.Application;
import com.erzbir.accountbook.application.DefaultApplication;
import com.erzbir.accountbook.dao.AppDatabase;

/**
 * @author Erzbir
 * @Data: 2023/12/13
 */
public class AndroidApplication extends Application {
    public static final AndroidApplication INSTANCE = new AndroidApplication();
    public final com.erzbir.accountbook.application.Application APP = new DefaultApplication();
    public AppDatabase DB;

    @Override
    public void onCreate() {
        super.onCreate();
    }

}
