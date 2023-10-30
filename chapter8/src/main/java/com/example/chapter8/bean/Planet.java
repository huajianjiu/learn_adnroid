package com.example.chapter8.bean;

import com.example.chapter8.R;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    public int image;
    public String name;
    public String desc;

    public Planet(int image, String name, String desc){
        this.image = image;
        this.name = name;
        this.desc =desc;
    }

    public static int[] iconArray = {
            R.drawable.honor,R.drawable.honor_x50,R.drawable.huawei_mate_60_b,
            R.drawable.huawei_x_5_1,R.drawable.iphone1,R.drawable.oppo
    };
    public static String[] nameArray = {"水星","金星","地球","火星","木星","土星"};
    public static String[] descArray = {
            "水星X射线啊伤心啊所产生的出VSDVD发VB代发vFDD发vv地方v地方v给对方VB地方",
            "金星擦啊擦读书的v地方v发大V电饭煲地方北大法宝",
            "地球大Vv发v，了，绿色的吗，V领没事代理费v吗",
            "火星承担深V测试大V百度发不发VB发VB从感染儿童画人挤人体育特意",
            "木星也如果哪天辅导班你同意有问必答发给v地方v",
            "土星取快递了vldml;mdlm理论框架世界年纪斯康杜尼看上你开除你"
    };

    public static List<Planet> getDefaultList() {
        List<Planet> planetList = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            planetList.add(new Planet(iconArray[i],nameArray[i],descArray[i]));
        }
        return planetList;
    }
}
