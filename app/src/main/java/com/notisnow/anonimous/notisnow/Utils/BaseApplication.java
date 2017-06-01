package com.notisnow.anonimous.notisnow.Utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by yang-gichang on 2017. 5. 31..
 */

public class BaseApplication extends Application {
    private static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {

        super.onCreate();
        Log.d("testingBaseApplication","started");
        initNetwork();

    }

    private void initNetwork(){
        Context context=getApplicationContext();
        mRequestQueue= Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue(){
        return mRequestQueue;
    }
}
