package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnandroid.dao.BookDao;
import com.example.learnandroid.enity.BookInfo;

import java.util.List;

public class RoomWriteActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText book_name;
    private EditText writer_name;
    private EditText press_name;
    private EditText book_price;
    private BookDao bookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_write);

        book_name = findViewById(R.id.book_name);
        writer_name = findViewById(R.id.writer_name);
        press_name = findViewById(R.id.press_name);
        book_price = findViewById(R.id.book_price);

        findViewById(R.id.bt_add).setOnClickListener(this);
        findViewById(R.id.bt_del).setOnClickListener(this);
        findViewById(R.id.bt_update).setOnClickListener(this);
        findViewById(R.id.bt_search).setOnClickListener(this);

        bookDao = MyApplication.getInstance().getBookDB().bookDao();
    }

    @Override
    public void onClick(View view) {
        String name = book_name.getText().toString();
        String writer = writer_name.getText().toString();
        String press = press_name.getText().toString();
        String price = book_price.getText().toString();

        if(view.getId()==R.id.bt_add){
            BookInfo b1 = new BookInfo();
            b1.setName(name);
            b1.setWriter(writer);
            b1.setPress(press);
            b1.setPrice(Double.parseDouble(price));
            bookDao.insert(b1);
            Toast.makeText(RoomWriteActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.bt_del){
            BookInfo b2 = new BookInfo();
            b2.setId(1);
            bookDao.delete(b2);
            Toast.makeText(RoomWriteActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
        }else if(view.getId()==R.id.bt_update){
            BookInfo b3 = new BookInfo();
            BookInfo b4 = bookDao.queryByName(name);
            b3.setId(b4.getId());
            b3.setName(name);
            b3.setWriter(writer);
            b3.setPress(press);
            b3.setPrice(Double.parseDouble(price));
            bookDao.insert(b3);
//            b3.setId();
        }else if(view.getId()==R.id.bt_search){
            List<BookInfo> list = bookDao.queryAll();
            for (BookInfo item: list){
                Log.d("zhao", item.toString());
            }
        }
    }
}