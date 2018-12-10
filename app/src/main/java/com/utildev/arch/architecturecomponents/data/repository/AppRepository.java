package com.utildev.arch.architecturecomponents.data.repository;

import com.google.gson.JsonObject;
import com.utildev.arch.architecturecomponents.data.remote.RemoteDataSource;
import com.utildev.arch.architecturecomponents.data.room.RoomDataSource;
import com.utildev.arch.architecturecomponents.data.room.model.UserEntity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

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

    public List<Disposable> getDisposables() {
        return disposables;
    }

    @Override
    public Observable<JsonObject> getUserStackExchange(String order, String sort, String site, int page) {
//        MutableLiveData<RestUserSE> mutableLiveData = new MutableLiveData<>();
//        Disposable disposable = remoteDataSource.requestUserSE(order, sort, site, page)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(jsonObject -> {
//                    if (jsonObject != null) {
//                        Type type = new TypeToken<RestUserSE>() {
//                        }.getType();
//                        mutableLiveData.setValue(new Gson().fromJson(jsonObject, type));
//                    } else {
//                        mutableLiveData.setValue(null);
//                    }
//                }, Throwable::printStackTrace);
//        disposables.add(disposable);
        return remoteDataSource.requestUserSE(order, sort, site, page);
    }

    @Override
    public Flowable<Integer> getUserCount() {
        return roomDataSource.getUserDao().getUserTotal();
    }

    @Override
    public Flowable<List<UserEntity>> getAllUser() {
//        MutableLiveData<List<UserEntity>> mutableLiveData = new MutableLiveData<>();
//        Disposable disposable = roomDataSource.getUserDao().getAllUser()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(userEntities -> {
//                    if (userEntities != null) {
//                        mutableLiveData.setValue(userEntities);
//                    } else {
//                        mutableLiveData.setValue(null);
//                    }
//                }, Throwable::printStackTrace);
//        disposables.add(disposable);
        return roomDataSource.getUserDao().getAllUser();
    }

    @Override
    public void addUser(UserEntity userEntity) {
        roomDataSource.getUserDao().insertUser(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        roomDataSource.getUserDao().deleteUser(userEntity);
    }
}
