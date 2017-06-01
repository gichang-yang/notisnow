package com.notisnow.anonimous.notisnow.UI;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.notisnow.anonimous.notisnow.Adapter.MajorAdapter;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.Model.Notice;
import com.notisnow.anonimous.notisnow.staticField.Data;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;


/**
 * Created by yang-gichang on 2017. 5. 29..
 */


public class MainPresenter implements MainContract.Presenter {
    private MainActivity mainActivity;
    MainContract.View view;
    RequestQueue queue;
    StringBuffer result;
    Elements element;
    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void setView(MainContract.View v) {
        this.view=view;
    }

    public String fetch(String url){
       // BaseApplication application = new BaseApplication();
        //application.onCreate();
        //queue= BaseApplication.getRequestQueue();
       // Log.d("Request queue is...",queue.toString());
        queue= Volley.newRequestQueue(mainActivity.getContext());

        result= new StringBuffer("");

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("responseREQUESTQUEUE",response);
                        result.append(response.toString());
                        element= new Element(result.toString()).select("td.title");
                        Log.d("selected elements",element.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        result.append("error");
                        Log.d("responseREQUESTQUEUE","error");
                    }
                }

        );
        Log.d("stringREQ",stringRequest.toString());
        //try {
            queue.add(stringRequest);
        //}catch (Exception e){
        //    e.printStackTrace();
        //}
       return result.toString();
    }


    @Override
    public ArrayList<Notice> getNoticeList(int id) {
        String tag=fetch(Data.getUrl()[id]);

                Log.d("fetched",tag);



        switch(id){
            case 0:
                //Log.d("elements",element.select("td.title").toString());
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }

        return null;
    }


    @Override
    public NoticeAdapter getNoticeAdapter() {
        return new NoticeAdapter();
    }
    @Override
    public MajorAdapter getMajorAdapter() {
        return null;
    }
}
