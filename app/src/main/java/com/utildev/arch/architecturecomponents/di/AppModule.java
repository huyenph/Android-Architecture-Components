package com.utildev.arch.architecturecomponents.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private MyApplication myApplication;

    public AppModule(MyApplication application) {
        this.myApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return myApplication;
    }
}
