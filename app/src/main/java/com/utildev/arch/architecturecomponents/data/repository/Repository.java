package com.utildev.arch.architecturecomponents.data.repository;

import android.arch.lifecycle.LiveData;

import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.data.room.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface Repository {
    LiveData<RestUserSE> getUserStackExchange(String order, String sort, String site, int page);

    Flowable<Integer> getUserCount();

    LiveData<List<UserEntity>> getAllUser();

    void addUser(UserEntity userEntity);
}
