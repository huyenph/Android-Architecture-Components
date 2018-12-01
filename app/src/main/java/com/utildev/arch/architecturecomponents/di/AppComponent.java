package com.utildev.arch.architecturecomponents.di;

import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RemoteModule.class, RoomModule.class})
@Singleton
public interface AppComponent {
    void inject(BaseViewModel baseViewModel);
}
