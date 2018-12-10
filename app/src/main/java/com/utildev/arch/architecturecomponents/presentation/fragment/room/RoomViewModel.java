package com.utildev.arch.architecturecomponents.presentation.fragment.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.architecturecomponents.data.room.model.UserEntity;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomViewModel extends BaseViewModel {
    private MutableLiveData<List<UserEntity>> userLiveData;
    private MutableLiveData<Integer> userCount;

    LiveData<List<UserEntity>> getUserLiveData() {
        return userLiveData;
    }

    MutableLiveData<Integer> getUserCount() {
        return userCount;
    }

    void getAllUser() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
        }
        showLoading(null);
        Disposable disposable = getRepository().getAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userEntities -> {
                    userLiveData.setValue(userEntities);
                    dismissLoading(null);
                }, Throwable::printStackTrace);
        getCompositeDisposable().add(disposable);
    }

    void insertUser(UserEntity userEntity) {
        Disposable disposable = Observable.create(emitter -> {
            getRepository().addUser(userEntity);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object -> {
                }, Throwable::printStackTrace, this::getAllUser);
        getCompositeDisposable().add(disposable);
    }

    void getTotalUserCount() {
        if (userCount == null) {
            userCount = new MutableLiveData<>();
        }
        Disposable disposable = getRepository().getUserCount()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> userCount.setValue(integer), Throwable::printStackTrace);
        getCompositeDisposable().add(disposable);
    }

    void deleteUser(UserEntity userEntity) {
        Disposable disposable = Observable.create(emitter -> {
            getRepository().deleteUser(userEntity);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object -> {
                }, Throwable::printStackTrace, this::getAllUser);
        getCompositeDisposable().add(disposable);
    }
}
