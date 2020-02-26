package com.bw.miaoheng20200226.presenter;

import com.bw.miaoheng20200226.base.mvp.BasePresenter;
import com.bw.miaoheng20200226.contract.IContract;
import com.bw.miaoheng20200226.model.Model;

/**
 * 时间 :2020/2/26  16:45
 * 作者 :苗恒
 * 功能 :
 */
public class Presenter extends BasePresenter<Model, IContract.IView> implements IContract.IPresenter {
    @Override
    protected Model initModel() {
        return new Model();
    }

    @Override
    public void login(String phone, String pwd) {
        model.login(phone, pwd, new IContract.IModel.ModelCallBack() {
            @Override
            public void seccess(Object object) {
                getView().seccess(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }

    @Override
    public void register(String phone, String pwd) {
        model.register(phone, pwd, new IContract.IModel.ModelCallBack() {
            @Override
            public void seccess(Object object) {
                getView().seccess(object);
            }

            @Override
            public void failur(Throwable throwable) {
                getView().failur(throwable);
            }
        });
    }
}
