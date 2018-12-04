package com.utildev.arch.architecturecomponents.presentation.activity.main;

import android.content.ContextWrapper;
import android.view.View;

import com.utildev.arch.architecturecomponents.presentation.BaseViewModel;
import com.utildev.arch.architecturecomponents.presentation.fragment.remote.RemoteFragment;
import com.utildev.arch.architecturecomponents.presentation.fragment.room.RoomFragment;

public class ActMainViewModel extends BaseViewModel {
    public void onClickRoom(View view) {
        if (view.getContext() instanceof BaseActivity) {
            ((BaseActivity) view.getContext()).addFragment(new RoomFragment(), true, true);
        } else if (view.getContext() instanceof ContextWrapper) {
            ((BaseActivity) ((ContextWrapper) view.getContext()).getBaseContext())
                    .addFragment(new RoomFragment(), true, true);
        }
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
