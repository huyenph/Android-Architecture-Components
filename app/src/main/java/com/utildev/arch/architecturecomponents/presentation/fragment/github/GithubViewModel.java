package com.utildev.arch.architecturecomponents.presentation.fragment.github;

import android.view.View;

import com.utildev.arch.architecturecomponents.data.room.model.Github;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;

import org.greenrobot.eventbus.EventBus;

public class GithubViewModel extends BaseViewModel {
    public void onClickSend(View view) {
        EventBus.getDefault().post(new Github("Architecture Components", "retrofit2", "github.com"));
    }
}
