package com.utildev.arch.architecturecomponents.data.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.utildev.arch.architecturecomponents.data.room.model.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {
    @Query("SELECT COUNT(*) FROM " + RoomConstant.USER)
    Flowable<Integer> getUserTotal();

    @Query("SELECT * FROM " + RoomConstant.USER)
    Flowable<List<UserEntity>> getAllUser();

    @Insert
    void insertUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity userEntity);
}
