package com.bw.miaoheng20200226;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.image);
        //接收值
        String headPic = getIntent().getStringExtra("headPic");
        Glide.with(this).load(headPic)
                .circleCrop()
                .into(imageView);
    }
}
