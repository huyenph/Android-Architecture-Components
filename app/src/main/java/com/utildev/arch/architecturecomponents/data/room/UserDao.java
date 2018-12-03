package com.utildev.arch.architecturecomponents.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

@Dao
public interface UserDao {
    @Query("SELECT COUNT(*) FROM " + RoomConstant.USER)
    Flowable<Integer> getUserTotal();

    @Query("SELECT * FROM " + RoomConstant.USER)
    Flowable<List<UserEntity>> getAllUser();

    @Insert
    void insertUser(UserEntity userEntity);
}
