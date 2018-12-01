package com.utildev.arch.architecturecomponents.presentation.fragment.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

public class RemoteViewModel extends BaseViewModel {
    private LiveData<RestUserSE> userSELiveData = null;

    public LiveData<RestUserSE> getUserSELiveData() {
        return userSELiveData;
    }

    void getUserSE(String order, String sort, String site, int page) {
        if (userSELiveData == null) {
            userSELiveData = new MutableLiveData<>();
        }
        userSELiveData = getRepository().getUserStackExchange(order, sort, site, page);
    }
}
