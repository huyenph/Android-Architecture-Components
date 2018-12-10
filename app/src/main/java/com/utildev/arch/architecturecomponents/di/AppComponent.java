package com.utildev.arch.architecturecomponents.di;

import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;
import com.utildev.arch.architecturecomponents.presentation.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, RemoteModule.class, RoomModule.class, SharedPreferencesModule.class})
@Singleton
public interface AppComponent {
    void inject(BaseViewModel baseViewModel);

    void inject(BaseActivity baseActivity);
}
