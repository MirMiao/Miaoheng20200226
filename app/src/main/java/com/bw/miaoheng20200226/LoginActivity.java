package com.bw.miaoheng20200226;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EncryptUtils;
import com.bw.miaoheng20200226.base.BaseActivity;
import com.bw.miaoheng20200226.contract.IContract;
import com.bw.miaoheng20200226.entity.LoginEntity;
import com.bw.miaoheng20200226.entity.RegisterEntity;
import com.bw.miaoheng20200226.presenter.Presenter;

public class LoginActivity extends BaseActivity<Presenter> implements IContract.IView {


    @Override
    protected void initView() {
        final EditText et_phone = findViewById(R.id.et_phone);
        final EditText et_pwd = findViewById(R.id.et_pwd);
        Button bt_login = findViewById(R.id.bt_login);
        Button bt_register = findViewById(R.id.bt_register);
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的内容
                String phone = et_phone.getText().toString();
                String pwd = et_pwd.getText().toString();
                //对密码进行加密
                String s = EncryptUtils.encryptMD5ToString(pwd);
                String substring = s.substring(0, 6);
                Log.i("xxx","加密后的密码"+s);
                Log.i("xxx","截取加密后的密码"+substring);
                presenter.register(phone,substring);
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的内容
                String phone = et_phone.getText().toString();
                String pwd = et_pwd.getText().toString();
                //对密码进行加密
                String s = EncryptUtils.encryptMD5ToString(pwd);
                String substring = s.substring(0, 6);
                //打印一下加密后的密码
                presenter.login(phone,substring);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_login;
    }

    @Override
    public void seccess(Object object) {
         if(object instanceof RegisterEntity){
             Toast.makeText(this, ""+((RegisterEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
         }else if(object instanceof LoginEntity){
             Toast.makeText(this, ""+((LoginEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
             if("0000".equals(((LoginEntity) object).getStatus())){
                 //跳转
                 Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                 //携带头像信息
                 intent.putExtra("headPic",((LoginEntity) object).getResult().getHeadPic());
                 startActivity(intent);
             }
         }
    }

    @Override
    public void failur(Throwable throwable) {

    }
}
