package com.zeidat.finalcar.services;

import com.zeidat.finalcar.models.Cookie;
import com.zeidat.finalcar.models.LoginUser;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("auth")
    Call<Cookie> getCookie(@Body LoginUser user) ;




}
