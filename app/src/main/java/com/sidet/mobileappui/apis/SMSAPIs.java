package com.sidet.mobileappui.apis;

import com.sidet.mobileappui.models.req.LoginReq;
import com.sidet.mobileappui.models.res.CategoryRes;
import com.sidet.mobileappui.models.res.LoginRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface SMSAPIs {
    @POST("/api/oauth/token")
    Call<LoginRes> login(@Body LoginReq req);
    @GET("/api/app/category/list")
    Call<CategoryRes> getAllCategory(@Header("Authorization") String token);
}
