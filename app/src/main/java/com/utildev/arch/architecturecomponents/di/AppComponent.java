package com.utildev.arch.architecturecomponents.di;

import com.utildev.arch.architecturecomponents.presentation.activity.ActMainVM;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RemoteModule.class, RoomModule.class})
@Singleton
public interface AppComponent {
    void inject(ActMainVM actMainVM);
}
