package com.bw.miaoheng20200226.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bw.miaoheng20200226.base.mvp.BasePresenter;
import com.bw.miaoheng20200226.base.mvp.IBaseView;

/**
 * 时间 :2020/2/26  16:29
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutid());
        presenter=initPresenter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView();
        initData();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract P initPresenter();

    protected abstract int bindLayoutid();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.deatch();
        }
    }
}
