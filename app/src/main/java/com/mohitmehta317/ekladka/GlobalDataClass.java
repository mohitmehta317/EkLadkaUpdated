package com.mohitmehta317.ekladka;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;

public class GlobalDataClass {
    @SuppressLint("StaticFieldLeak")
    public static Context context=null;
    public static Boolean English=false;
    public static int check=0;
    public Typeface setfont(){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    return context.getResources().getFont(R.font.bitterbold);
        }
        return null;
    }
}
