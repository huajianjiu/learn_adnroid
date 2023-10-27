package com.example.learnandroid;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import androidx.room.Room;

import com.example.learnandroid.dao.GoodsDao;
import com.example.learnandroid.data.GoodsData;
import com.example.learnandroid.database.BookDatabase;
import com.example.learnandroid.database.ShoppingDatabase;
import com.example.learnandroid.enity.GoodsInfo;
import com.example.learnandroid.utils.FileUitls;
import com.example.learnandroid.utils.SharedUtils;

import java.io.File;
import java.util.List;

public class MyApplication extends Application {
    private static MyApplication mApp;
    private BookDatabase bookDatabase;

    private ShoppingDatabase shoppingDatabase;

    public static MyApplication getInstance(){
        return mApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        bookDatabase = Room.databaseBuilder(this,BookDatabase.class,"book")
                .addMigrations()
                // 允许在主线程中操作数据库（Room默认不允许在主线程中操作数据库）
                .allowMainThreadQueries()
                .build();
        shoppingDatabase = Room.databaseBuilder(this,ShoppingDatabase.class,"shopping")
                .addMigrations()
                // 允许在主线程中操作数据库（Room默认不允许在主线程中操作数据库）
                .allowMainThreadQueries()
                .build();

        initGoodsInfo();
    }

    private void initGoodsInfo() {
        // 获取共享参数保存的是否首次打开参数
        boolean isFirst = SharedUtils.getInstance(this).readBoolean("first",true);
        String directory = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString()+ File.separatorChar;
        if(isFirst){
            // 模拟网络图片的下载
            List<GoodsData> list = GoodsData.getDefaultList();
            for (GoodsData info : list) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), info.pic);
                String path = directory+info.id+".png";
                FileUitls.saveImage(path,bitmap);
                if(bitmap!=null&&!bitmap.isRecycled()){
                    bitmap.recycle();
                }
                info.picPath = path;
            }
            // 插入数据库
            GoodsDao sp = shoppingDatabase.goodsDao();
            for (GoodsData item : list) {
                GoodsInfo data = new GoodsInfo();
//                data.setId(item.id);
                data.setName(item.name);
                data.setDesc(item.desc);
                data.setPrice(item.price);
                data.setPic_path(item.picPath);
                sp.insert(data);
            }
            // 修改是否首次打开的状态
            SharedUtils.getInstance(this).writeBoolean("first",false);
        }
    }

    public BookDatabase getBookDB(){
        return bookDatabase;
    }

    public ShoppingDatabase getShoppingDatabase(){return shoppingDatabase;}
}
