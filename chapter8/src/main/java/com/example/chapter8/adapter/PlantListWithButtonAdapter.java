package com.example.chapter8.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chapter8.R;
import com.example.chapter8.SpinnerDropdownActivity;
import com.example.chapter8.bean.Planet;

import java.util.List;

public class PlantListWithButtonAdapter extends BaseAdapter {

    private Context mContext;
    private List<Planet> mPlaneList;

    public PlantListWithButtonAdapter(Context mContext, List<Planet> mPlaneList) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.item_list_with_button, null);
            holder = new ViewHolder();
            holder.iv_icon = view.findViewById(R.id.iv_icon);
            holder.tv_name = view.findViewById(R.id.tv_name);
            holder.tv_desc = view.findViewById(R.id.tv_desc);
            holder.btn_oper = view.findViewById(R.id.btn_oper);
            holder.ll_item = view.findViewById(R.id.ll_item);
            // 将视图持有者保存到转化视图中
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        Planet planet = mPlaneList.get(i);
        holder.ll_item.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        holder.btn_oper.setOnClickListener(v -> {
            Toast.makeText(mContext,"按钮被点击"+planet.name,Toast.LENGTH_SHORT).show();
        });
        return view;
    }

    public final class ViewHolder {
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_desc;
        public Button btn_oper;
        public LinearLayout ll_item;
    }
}
