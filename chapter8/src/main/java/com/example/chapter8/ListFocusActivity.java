package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chapter8.adapter.PlantListWithButtonAdapter;
import com.example.chapter8.bean.Planet;

import java.util.List;

public class ListFocusActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Planet> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_focus);
        ListView lv_planet = findViewById(R.id.lv_planet);
        lv_planet.setOnItemClickListener(this);
        list = Planet.getDefaultList();
        PlantListWithButtonAdapter adapter = new PlantListWithButtonAdapter(this, list);
        lv_planet.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"条目被点击"+ list.get(i).name,Toast.LENGTH_SHORT).show();
    }
}