package com.utildev.arch.architecturecomponents.presentation;

import android.arch.lifecycle.ViewModel;

import com.utildev.arch.architecturecomponents.data.repository.AppRepository;
import com.utildev.arch.architecturecomponents.di.MyApplication;

import javax.inject.Inject;

public class BaseViewModel extends ViewModel {
    @Inject
    AppRepository repository;

    protected AppRepository getRepository() {
        return repository;
    }

    public BaseViewModel() {
        MyApplication.appComponent.inject(this);
    }
}
