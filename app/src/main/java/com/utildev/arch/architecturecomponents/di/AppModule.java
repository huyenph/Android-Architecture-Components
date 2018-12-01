package com.utildev.arch.architecturecomponents.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {
    private MyApplication myApplication;

    AppModule(MyApplication application) {
        this.myApplication = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return myApplication;
    }
}
