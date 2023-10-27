package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        // 获取到屏幕的宽度
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        Log.d("zhao", "showGoods: "+screenWidth);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((screenWidth) / 2, LinearLayout.LayoutParams.WRAP_CONTENT);
        List<GoodsInfo> goodsList = goodsDao.queryAll();
        for (GoodsInfo item : goodsList) {
            Log.d("zhao", item.toString());
            // 获取布局文件item_goods.xml的根视图
            View view = LayoutInflater.from(this).inflate(R.layout.item_goods, null);
            ImageView iv_thumb = view.findViewById(R.id.iv_thumb);
            TextView tv_name = view.findViewById(R.id.tv_name);
            TextView tv_price = view.findViewById(R.id.tv_price);

            iv_thumb.setImageURI(Uri.parse(item.getPic_path()));
            tv_name.setText(item.getName());
            tv_price.setText(item.getPrice().toString());
            // 添加到表格布局中
            gl_channel.addView(view,params);
        }
    }
}