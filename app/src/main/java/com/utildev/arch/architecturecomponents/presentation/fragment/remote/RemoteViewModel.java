package com.utildev.arch.architecturecomponents.presentation.fragment.remote;

import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import java.lang.reflect.Type;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemoteViewModel extends BaseViewModel {
    private MutableLiveData<RestUserSE> userSELiveData = null;

    MutableLiveData<RestUserSE> getUserSELiveData() {
        return userSELiveData;
    }

    void getUserSE(String order, String sort, String site, int page, boolean showLoading) {
        if (showLoading) {
            showLoading(null);
        }
        if (userSELiveData == null) {
            userSELiveData = new MutableLiveData<>();
        }
        Disposable disposable = getRepository().getUserStackExchange(order, sort, site, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(jsonObject -> {
                    if (jsonObject != null) {
                        Type type = new TypeToken<RestUserSE>() {
                        }.getType();
                        userSELiveData.setValue(new Gson().fromJson(jsonObject, type));
                        dismissLoading(null);
                    }
                }, Throwable::printStackTrace);
        getCompositeDisposable().add(disposable);
    }
}
