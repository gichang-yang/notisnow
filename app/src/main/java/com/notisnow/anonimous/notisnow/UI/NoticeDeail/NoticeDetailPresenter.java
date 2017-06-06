package com.notisnow.anonimous.notisnow.UI.NoticeDeail;

import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.notisnow.anonimous.notisnow.BaseApplication;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yang-gichang on 2017. 6. 4..
 */

public class NoticeDetailPresenter implements NoticeDetailContract.Presenter {
    NoticeDetailContract.View view;
    WebView contents;

    NoticeDetailActivity activity;
    @Override
    public void setView(NoticeDetailContract.View v) {
        this.view=v;
        this.activity=(NoticeDetailActivity)v;
    }


    @Override
    public void fetch(String url) {
        RequestQueue queue= BaseApplication.getRequestQueue();
        StringRequest tag=new StringRequest( url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document doc= Jsoup.parse(response);
                Elements elements = doc.select("[id=\"contentsdiv\"]");
                String html=elements.get(0).text();
                html=html.replace("<img","<img width=400 ");

               // contents=view.getWebView();
                contents=activity.webView;
                contents.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                contents.getSettings().setLoadWithOverviewMode(true);
                contents.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("detail response","receive error.");
            }
        });

        queue.add(tag);
    }

    @Override
    public void postFetch(String url, ArrayList<String> token) {
        RequestQueue queue=BaseApplication.getRequestQueue();
        StringRequest tag=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document doc= Jsoup.parse(response);
                Elements elements = doc.select("[id=\"contentsdiv\"]");
                String html=elements.get(0).text();
                html=html.replace("<img","<img width=400 ");

                // contents=view.getWebView();
                contents=activity.webView;
                contents.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                contents.getSettings().setLoadWithOverviewMode(true);
                contents.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("home_id","cs");
                params.put("board_seq","1906");



                return params;
            }
        };
    }


}
