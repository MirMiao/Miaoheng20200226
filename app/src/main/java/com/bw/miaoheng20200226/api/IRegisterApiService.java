package com.bw.miaoheng20200226.api;

import com.bw.miaoheng20200226.entity.LoginEntity;
import com.bw.miaoheng20200226.entity.RegisterEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 时间 :2020/2/26  16:40
 * 作者 :苗恒
 * 功能 :
 */
public interface IRegisterApiService {
    @FormUrlEncoded
    @POST("small/user/v1/register")
    Observable<RegisterEntity> register(@Field("phone") String phone, @Field("pwd") String pwd);
}
