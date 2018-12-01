package com.utildev.arch.architecturecomponents.data.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.utildev.arch.architecturecomponents.data.remote.RemoteDataSource;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestItemSE;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.data.room.RoomDataSource;
import com.utildev.arch.architecturecomponents.data.room.UserEntity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AppRepository implements Repository {
    private RemoteDataSource remoteDataSource;
    private RoomDataSource roomDataSource;
    private List<Disposable> disposables;

    @Inject
    public AppRepository(RemoteDataSource remoteDataSource, RoomDataSource roomDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.roomDataSource = roomDataSource;
        disposables = new ArrayList<>();
    }

    @Override
    public LiveData<JsonObject> getUserStackExchange(String order, String sort, String site, int page) {
        MutableLiveData<JsonObject> mutableLiveData = new MutableLiveData<>();
        Disposable disposable = remoteDataSource.requestUserSE(order, sort, site, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jsonObject -> {
                    if (jsonObject != null) {
                        mutableLiveData.setValue(jsonObject);
                    } else {
                        mutableLiveData.setValue(null);
                    }
                }, Throwable::printStackTrace);
        disposables.add(disposable);
        return mutableLiveData;
    }

    @Override
    public Flowable<Integer> getUserCount() {
        return null;
    }

    @Override
    public LiveData<List<UserEntity>> getAllUser() {
        return null;
    }

    @Override
    public void addUser() {

    }
}
