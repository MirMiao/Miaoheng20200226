package com.bw.miaoheng20200226.model;

import com.bw.miaoheng20200226.api.ILoginApiService;
import com.bw.miaoheng20200226.api.IRegisterApiService;
import com.bw.miaoheng20200226.contract.IContract;
import com.bw.miaoheng20200226.entity.LoginEntity;
import com.bw.miaoheng20200226.entity.RegisterEntity;
import com.bw.miaoheng20200226.util.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 时间 :2020/2/26  16:45
 * 作者 :苗恒
 * 功能 :
 */
public class Model implements IContract.IModel {
    @Override
    public void login(String phone, String pwd, final ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().creatService(ILoginApiService.class)
                .login(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        modelCallBack.seccess(loginEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }

    @Override
    public void register(String phone, String pwd, final ModelCallBack modelCallBack) {
        RetrofitUtil.getInstance().creatService(IRegisterApiService.class)
                .register(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterEntity>() {
                    @Override
                    public void accept(RegisterEntity registerEntity) throws Exception {
                        modelCallBack.seccess(registerEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        modelCallBack.failur(throwable);
                    }
                });
    }
}
