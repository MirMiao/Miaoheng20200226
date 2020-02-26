package com.bw.miaoheng20200226.util;

import com.bw.miaoheng20200226.api.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 时间 :2020/2/26  16:36
 * 作者 :苗恒
 * 功能 :
 */
public class RetrofitUtil {
    private static RetrofitUtil retrofitUtil=new RetrofitUtil();
    private final Retrofit retrofit;

    private RetrofitUtil() {
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static RetrofitUtil getInstance() {
        return retrofitUtil;
    }
    public <T>T creatService(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
