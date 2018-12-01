package com.utildev.arch.architecturecomponents.presentation;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.view.View;

import com.utildev.arch.architecturecomponents.data.repository.AppRepository;
import com.utildev.arch.architecturecomponents.di.MyApplication;

import javax.inject.Inject;

public abstract class BaseViewModel extends ViewModel {
    @Inject
    AppRepository repository;

    private ObservableInt loadingView;

    public BaseViewModel() {
        MyApplication.appComponent.inject(this);
        loadingView = new ObservableInt(View.GONE);
    }

    protected AppRepository getRepository() {
        return repository;
    }

    public ObservableInt getLoadingView() {
        return loadingView;
    }

    //region TODO: Control loading view
    public void showLoading(View view) {
        if (loadingView.get() != View.VISIBLE) {
            loadingView.set(View.VISIBLE);
        }
    }

    public void dismissLoading(View view) {
        if (loadingView.get() != View.GONE) {
            loadingView.set(View.GONE);
        }
    }
    //endregion
}
