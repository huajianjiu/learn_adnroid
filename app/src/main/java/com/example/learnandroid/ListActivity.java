package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learnandroid.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        RecyclerView rv = findViewById(R.id.rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);

        rv.setHasFixedSize(false);
        ArrayList<String> strings =  new ArrayList<>();

        for (int i = 0; i < 100; i++){
            strings.add("数据"+i);
        }

        ListAdapter adapter = new ListAdapter(this,strings);
        rv.setAdapter(adapter);
    }
}