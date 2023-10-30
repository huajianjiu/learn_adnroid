package com.example.chapter8;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.chapter8.adapter.PlantBaseAdapter;
import com.example.chapter8.bean.Planet;
import com.example.chapter8.utils.Utils;

import java.util.List;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, CompoundButton.OnCheckedChangeListener {

    private List<Planet> planetList;
    private CheckBox ck_divider;
    private CheckBox ck_selector;
    private ListView lv_planet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lv_planet = findViewById(R.id.lv_planet);
        planetList = Planet.getDefaultList();
        PlantBaseAdapter adapter = new PlantBaseAdapter(this, planetList);
        lv_planet.setAdapter(adapter);

        lv_planet.setOnItemClickListener(this);

        ck_divider = findViewById(R.id.ck_divider);
        ck_divider.setOnCheckedChangeListener(this);
        ck_selector = findViewById(R.id.ck_selector);
        ck_selector.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"您选中的是"+planetList.get(i).name,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId()==R.id.ck_divider){
            if(ck_divider.isChecked()){
                Drawable drawable = getResources().getDrawable(R.color.black,getTheme());
                lv_planet.setDivider(drawable);
                lv_planet.setDividerHeight(Utils.dip2px(this,1));
            }else{
                lv_planet.setDivider(null);
                lv_planet.setDividerHeight(Utils.dip2px(this,0));
            }
        }
        if(compoundButton.getId()==R.id.ck_selector){
            if(ck_selector.isChecked()){
                lv_planet.setSelector(R.drawable.list_selector);
            }else{
                Drawable drawable = getResources().getDrawable(R.color.transparent, getTheme());
                lv_planet.setSelector(drawable);
            }
        }
    }
}