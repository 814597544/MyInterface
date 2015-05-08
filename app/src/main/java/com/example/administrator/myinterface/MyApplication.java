package com.example.administrator.myinterface;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2015/4/20.
 */
public class MyApplication extends Application {
    Context context;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
