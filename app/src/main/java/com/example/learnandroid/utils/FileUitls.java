package com.example.learnandroid.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUitls {
    public static void saveImage(String path, Bitmap bitmap) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public static Bitmap openImage(String path){
        Bitmap bitmap = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(path);
            bitmap = BitmapFactory.decodeStream(fis);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return bitmap;
    }
}
