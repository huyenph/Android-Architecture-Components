package com.utildev.arch.architecturecomponents.di;

import android.app.Application;

public class MyApplication extends Application {
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .remoteModule(new RemoteModule())
                .roomModule(new RoomModule())
                .build();
    }
}
