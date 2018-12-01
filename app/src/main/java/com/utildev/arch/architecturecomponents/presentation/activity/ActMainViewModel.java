package com.utildev.arch.architecturecomponents.presentation.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

class ActMainViewModel extends BaseViewModel {
    private LiveData<RestUserSE> userSELiveData = null;

    LiveData<RestUserSE> getUserSE(String order, String sort, String site, int page) {
        if (userSELiveData == null) {
            userSELiveData = new MutableLiveData<>();
            userSELiveData = getRepository().getUserStackExchange(order, sort, site, page);
        }
        return userSELiveData;
    }
}
