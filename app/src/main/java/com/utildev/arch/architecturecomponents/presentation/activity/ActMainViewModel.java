package com.utildev.arch.architecturecomponents.presentation.activity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.ContextWrapper;
import android.view.View;

import com.utildev.arch.architecturecomponents.data.remote.stackexchange.RestUserSE;
import com.utildev.arch.architecturecomponents.presentation.BaseActivity;
import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;
import com.utildev.arch.architecturecomponents.presentation.fragment.remote.RemoteFragment;

public class ActMainViewModel extends BaseViewModel {
    private LiveData<RestUserSE> userSELiveData = null;

    LiveData<RestUserSE> getUserSE(String order, String sort, String site, int page) {
        if (userSELiveData == null) {
            userSELiveData = new MutableLiveData<>();
            userSELiveData = getRepository().getUserStackExchange(order, sort, site, page);
        }
        return userSELiveData;
    }

    public void onClickRoom(View view) {

    }

    public void onClickWebservice(View view) {
        if (view.getContext() instanceof BaseActivity) {
            ((BaseActivity) view.getContext()).addFragment(new RemoteFragment(), true, true);
        } else if (view.getContext() instanceof ContextWrapper) {
            ((BaseActivity) ((ContextWrapper) view.getContext()).getBaseContext())
                    .addFragment(new RemoteFragment(), true, true);
        }
    }

    public void onClickGithub(View view) {

    }
}
