package com.bw.miaoheng20200226.contract;

import com.bw.miaoheng20200226.base.mvp.IBaseModel;
import com.bw.miaoheng20200226.base.mvp.IBaseView;

/**
 * 时间 :2020/2/26  16:42
 * 作者 :苗恒
 * 功能 :
 */
public interface IContract {
    interface IModel extends IBaseModel{
        void login(String phone,String pwd,ModelCallBack modelCallBack);
        void register(String phone,String pwd,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void seccess(Object object);
            void failur(Throwable throwable);
        }
    }
    interface IView extends IBaseView{
        void seccess(Object object);
        void failur(Throwable throwable);
    }
    interface IPresenter{
        void login(String phone, String pwd);
        void register(String phone, String pwd);
    }
}
