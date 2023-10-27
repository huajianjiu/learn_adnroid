package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid.adapter.ListAdapter;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // 创建OKHttp实例
    private OkHttpClient okHttpClient = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ListActivity.class);
                startActivity(intent);
            }
        });
    }

    public void requestNetwork(View view){
//        Toast.makeText(MainActivity.this,"点击按钮"+ ((Button) view).getText(),Toast.LENGTH_SHORT).show();
        new Thread(){
            @Override
            public void run(){
                super.run();
                // 创建一个Request，包含的需要请求的网址信息等
                // 这个类是一个构建设计模式
                Request request = new Request.Builder()
                        .url("https://baidu.com")
                        .build();
                // 调用newCall
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()){
                        String result = response.body().string();
                        Log.d(TAG, "network_data: "+result);
                    }else{
                        Log.e(TAG, "request network error");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();
    }
}