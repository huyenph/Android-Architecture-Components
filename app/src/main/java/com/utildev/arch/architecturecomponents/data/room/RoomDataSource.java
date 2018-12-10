package com.utildev.arch.architecturecomponents.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.utildev.arch.architecturecomponents.data.room.model.UserEntity;

@Database(entities = UserEntity.class, version = 1, exportSchema = false)
public abstract class RoomDataSource extends RoomDatabase {

    public abstract UserDao getUserDao();

    public static RoomDataSource createUserDB(Context context) {
        return Room.databaseBuilder(context, RoomDataSource.class, RoomConstant.DB_NAME).build();
    }
}
