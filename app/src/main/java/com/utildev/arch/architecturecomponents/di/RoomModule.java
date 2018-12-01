package com.utildev.arch.architecturecomponents.di;

import android.content.Context;

import com.utildev.arch.architecturecomponents.data.room.RoomDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Provides
    @Singleton
    RoomDataSource provideRoomDataSource(Context context) {
        return RoomDataSource.createUserDB(context);
    }
}
