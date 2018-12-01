package com.utildev.arch.architecturecomponents.data.repository;

import android.arch.lifecycle.LiveData;

import com.google.gson.JsonObject;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestItemSE;
import com.utildev.arch.architecturecomponents.data.room.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface Repository {
    LiveData<JsonObject> getUserStackExchange(String order, String sort, String site, int page);

    Flowable<Integer> getUserCount();

    LiveData<List<UserEntity>> getAllUser();

    void addUser();
}
