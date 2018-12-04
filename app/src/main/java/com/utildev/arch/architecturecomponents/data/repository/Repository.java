package com.utildev.arch.architecturecomponents.data.repository;

import com.google.gson.JsonObject;
import com.utildev.arch.architecturecomponents.data.room.UserEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface Repository {
    Observable<JsonObject> getUserStackExchange(String order, String sort, String site, int page);

    Flowable<Integer> getUserCount();

    Flowable<List<UserEntity>> getAllUser();

    void addUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);
}
