package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpinnerIconActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final int[] iconArray = {
            R.drawable.honor,R.drawable.honor_x50,R.drawable.huawei_mate_60_b,
            R.drawable.huawei_x_5_1,R.drawable.iphone1,R.drawable.oppo
    };
    public static final String[] starArray = {"水星","金星","地球","火星","木星","土星"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_icon);
        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            Map<String,Object> item = new HashMap<>();
            item.put("icon",iconArray[i]);
            item.put("name",starArray[i]);
            list.add(item);
        }
        
        SimpleAdapter starAdapter = new SimpleAdapter(this,list,
                R.layout.item_simple,
                new String[]{"icon","name"},
                new int[]{R.id.iv_icon,R.id.tv_name});
        Spinner sp_icon = findViewById(R.id.sp_icon);
        sp_icon.setAdapter(starAdapter);
        sp_icon.setSelection(0);
        sp_icon.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"您选择的是"+starArray[i],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}