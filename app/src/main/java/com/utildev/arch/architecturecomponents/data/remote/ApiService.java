package com.utildev.arch.architecturecomponents.data.remote;

import com.google.gson.JsonObject;
import com.utildev.arch.architecturecomponents.common.base.BaseModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users")
    Observable<JsonObject> requestUserSE(@Query("order") String order,
                                          @Query("sort") String sort,
                                          @Query("site") String site,
                                          @Query("page") int page);

    @FormUrlEncoded
    @POST("upload key, object")
    Observable<JsonObject> callNormal(@FieldMap Map<String, Object> body);

    @POST("upload file")
    Call<JsonObject> callFiles(@Body RequestBody file);

    @POST("upload list")
    Observable<JsonObject> callList(@Body List<BaseModel> body);

    @GET("not param")
    Observable<JsonObject> callNotParams();
}
