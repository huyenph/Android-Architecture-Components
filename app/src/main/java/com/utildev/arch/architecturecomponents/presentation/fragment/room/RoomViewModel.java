package com.utildev.arch.architecturecomponents.presentation.fragment.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.utildev.arch.architecturecomponents.data.room.UserEntity;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import java.util.List;

public class RoomViewModel extends BaseViewModel {
    private LiveData<List<UserEntity>> userLiveData;

    LiveData<List<UserEntity>> getUserLiveData() {
        return userLiveData;
    }

    void getUserRoom() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<>();
        }
        userLiveData = getRepository().getAllUser();
    }
}
