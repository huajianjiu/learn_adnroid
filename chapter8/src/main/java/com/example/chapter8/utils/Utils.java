package com.example.chapter8.utils;

import android.content.Context;

public class Utils {
    public static int dip2px(Context context, float dpValue) {
        // 获取当前手机的像素密度
        float scale = context.getResources().getDisplayMetrics().density;
        // 四舍五入取整
        return (int) (dpValue * scale + 0.5f);
    }
}
