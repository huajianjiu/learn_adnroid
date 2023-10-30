package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.chapter8.adapter.PlantGridAdapter;
import com.example.chapter8.bean.Planet;

import java.util.List;

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView gv_planet;
    private List<Planet> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gv_planet = findViewById(R.id.gv_planet);
        list = Planet.getDefaultList();
        PlantGridAdapter adapter = new PlantGridAdapter(this, list);
        gv_planet.setAdapter(adapter);
        gv_planet.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"按钮被点击"+list.get(i).name,Toast.LENGTH_SHORT).show();
    }
}