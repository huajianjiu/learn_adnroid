package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.learnandroid.dao.GoodsDao;
import com.example.learnandroid.enity.GoodsInfo;

import java.util.List;

public class ShoppingChannelActivity extends AppCompatActivity {

    private GoodsDao goodsDao;
    private TextView tv_count;
    private GridLayout gl_channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_channel);

        // 获得数据库实例
        // 获取商品表实例
        goodsDao = MyApplication.getInstance().getShoppingDatabase().goodsDao();

        TextView tv_title = findViewById(R.id.tv_title);
        tv_title.setText("手机商城");

        tv_count = findViewById(R.id.tv_count);
        gl_channel = findViewById(R.id.gl_channel);

        // 从数据库查询出商品信息并展示
        showGoods();


    }

    private void showGoods() {
        List<GoodsInfo> goodsList = goodsDao.queryAll();
        for (GoodsInfo item : goodsList) {

        }
    }
}