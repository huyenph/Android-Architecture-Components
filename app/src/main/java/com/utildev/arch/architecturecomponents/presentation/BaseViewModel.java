package com.utildev.arch.architecturecomponents.presentation;

import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.view.View;

import com.utildev.arch.architecturecomponents.data.repository.AppRepository;
import com.utildev.arch.architecturecomponents.di.MyApplication;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static android.arch.lifecycle.Lifecycle.Event.*;

public abstract class BaseViewModel extends ViewModel {
    @Inject
    AppRepository repository;
    private CompositeDisposable compositeDisposable;

    private ObservableInt loadingView;

    public BaseViewModel() {
        MyApplication.appComponent.inject(this);
        compositeDisposable = new CompositeDisposable();
        loadingView = new ObservableInt(View.GONE);
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
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

    @OnLifecycleEvent(ON_DESTROY)
    public void unSubscribeViewModel() {
//        for (Disposable disposable: repository.getDisposables()) {
//            compositeDisposable.addAll(disposable);
//        }

        compositeDisposable.clear();
    }

    @Override
    protected void onCleared() {
        unSubscribeViewModel();
        super.onCleared();
    }
}
