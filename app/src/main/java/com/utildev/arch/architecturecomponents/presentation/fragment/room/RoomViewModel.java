package com.utildev.arch.architecturecomponents.presentation.fragment.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.architecturecomponents.data.room.UserEntity;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RoomViewModel extends BaseViewModel {
    private MutableLiveData<List<UserEntity>> userLiveData;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    LiveData<List<UserEntity>> getUserLiveData() {
        return userLiveData;
    }

    void getUserRoom() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
        }
        Disposable disposable = getRepository().getAllUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(userEntities -> userLiveData.setValue(userEntities), Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    void insertUser(UserEntity userEntity) {
        Disposable disposable = Observable.create(emitter -> {
            getRepository().addUser(userEntity);
            emitter.onComplete();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object -> {
                }, Throwable::printStackTrace, this::getUserRoom);
        compositeDisposable.add(disposable);
    }
}
