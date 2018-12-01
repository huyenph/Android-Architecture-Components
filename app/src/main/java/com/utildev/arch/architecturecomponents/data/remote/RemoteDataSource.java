package com.utildev.arch.architecturecomponents.data.remote;

import com.google.gson.JsonObject;

import javax.inject.Inject;

import io.reactivex.Observable;

public class RemoteDataSource {
    private ApiService apiService;

    @Inject
    public RemoteDataSource(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<JsonObject> requestUserSE(String order, String sort, String site, int page) {
        if (apiService != null) {
             return apiService.requestUserSE(order, sort, site, page);
        }
        return null;
    }
}
