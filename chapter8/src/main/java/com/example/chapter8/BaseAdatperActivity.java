package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.chapter8.adapter.PlantBaseAdapter;
import com.example.chapter8.bean.Planet;

import java.util.List;

public class BaseAdatperActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<Planet> planets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adatper);

        Spinner sp_planet = findViewById(R.id.sp_planet);
        planets = Planet.getDefaultList();
        PlantBaseAdapter adapter = new PlantBaseAdapter(this, planets);
        sp_planet.setAdapter(adapter);
        sp_planet.setSelection(0);
        sp_planet.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"您选中的是"+planets.get(i).name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}