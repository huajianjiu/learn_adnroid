package com.example.chapter8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter8.R;
import com.example.chapter8.bean.Planet;

import java.util.List;

public class PlantGridAdapter extends BaseAdapter {

    private Context mContext;
    private List<Planet> mPlaneList;

    public PlantGridAdapter(Context mContext, List<Planet> mPlaneList) {
        this.mContext = mContext;
        this.mPlaneList = mPlaneList;
    }

    @Override
    public int getCount() {
        return mPlaneList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPlaneList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.item_grid, null);
            holder = new ViewHolder();
            holder.iv_icon = view.findViewById(R.id.iv_icon);
            holder.tv_name = view.findViewById(R.id.tv_name);
            holder.tv_desc = view.findViewById(R.id.tv_desc);
            // 将视图持有者保存到转化视图中
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Planet planet = mPlaneList.get(i);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        return view;
    }

    public final class ViewHolder {
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_desc;
    }
}
