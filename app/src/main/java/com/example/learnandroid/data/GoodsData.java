package com.example.learnandroid.data;

import com.example.learnandroid.R;

import java.util.ArrayList;

public class GoodsData {
    public  int id;
    public String name;
    public String desc;
    public Double price;
    public String picPath;
    public int pic;

    private  static String[] mNameArray = {
            "iPhone 15 Pro Max","HUAWEI MateX5","vivo Y78t","HUAWEI Mate 60 Pro","OPPO 1+ Ace 2 Pro","vivo iQOO Neo8","荣耀90","iPhone 13","Redmi K60","荣耀X50","HUAWEI Mate 60 Pro+","SAMSUNG Galaxy S23 Ultra",
    };

    private  static  String[] mDescArray = {
            "苹果 Apple iPhone 15 Pro Max 全网通5G 双卡双待 iPhone15pro 蓝色钛金属 128G",
            "华为MateX5折叠屏 新品 华为手机 华为X5 全国联保 羽砂黑 MateX5折叠屏 12GB+256GB",
            "vivo Y78t 8GB+256GB 雪域白 4nm第一代骁龙6 6000mAh大电池 5000万超清影像 5G 快充 拍照 手机",
            "华为（HUAWEI）旗舰手机 Mate 60 Pro 12GB+512GB 雅川青",
            "OPPO 一加 Ace 2 Pro 16GB+512GB 极光绿 高通第二代骁龙 8 旗舰芯片 长寿版 150W 超级闪充 5G游戏性能手机",
            "vivo iQOO Neo8 12GB+256GB 冲浪 第一代骁龙8+ 自研芯片V1+ 120W超快闪充 144Hz高刷 5G游戏电竞性能手机",
            "荣耀90 2亿像素超清相机 零风险调光护眼屏 5000mAh轻薄长续航 12GB+256GB 冰羽蓝 5G",
            "Apple iPhone 13 (A2634) 128GB 蓝色 支持移动联通电信5G 双卡双待手机",
            "Redmi K60 至尊版 天玑9200+ 独显芯片X7 1.5K直屏 索尼IMX800 光学防抖 16GB+512GB 墨羽 小米红米K60 Ultra",
            "荣耀X50 第一代骁龙6芯片 1.5K超清护眼硬核曲屏 5800mAh超耐久大电池 5G手机 8GB+128GB 雨后初晴",
            "华为（HUAWEI）旗舰手机 Mate 60 Pro+ 16GB+1TB 砚黑",
            "三星 SAMSUNG Galaxy S23 Ultra 超视觉夜拍 稳劲性能 大屏S Pen书写 8GB+256GB 悠远黑 5G手机",
    };

    private static Double[] mPriceArray = {9999.00,19999.00,1499.00,6999.00,3578.00,2299.00,1999.00,4397.00,2899.00,1399.00,9999.00,7299.00};

    private static  int[] mPicArray = {
            R.drawable.iphone1,
            R.drawable.huawei_x_5_1,
            R.drawable.vivo,
            R.drawable.huawei_mate_60_g,
            R.drawable.oppo,
            R.drawable.iqoo,
            R.drawable.honor,
            R.drawable.iphone_13,
            R.drawable.redmi,
            R.drawable.honor_x50,
            R.drawable.huawei_mate_60_b,
            R.drawable.sanson
    };

    public static ArrayList<GoodsData> getDefaultList() {
        ArrayList<GoodsData> goodsList = new ArrayList<>();
        for (int i = 0; i<mNameArray.length;i++){
            GoodsData info = new GoodsData();
            info.id = i;
            info.name = mNameArray[i];
            info.desc = mDescArray[i];
            info.price = mPriceArray[i];
            info.pic = mPicArray[i];
            goodsList.add(info);
        }
        return goodsList;
    }
}
