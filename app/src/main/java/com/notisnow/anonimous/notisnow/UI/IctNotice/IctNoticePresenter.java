package com.notisnow.anonimous.notisnow.UI.IctNotice;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.BaseApplication;
import com.notisnow.anonimous.notisnow.Model.Notice;
import com.notisnow.anonimous.notisnow.UI.NoticeDeail.NoticeDetailActivity;
import com.notisnow.anonimous.notisnow.staticField.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 4..
 */

public class IctNoticePresenter implements IctNoticeContract.Presenter {
    IctNoticeActivity activity;
    RequestQueue queue;
    int id;
    StringBuffer result;
    Elements element;
    ArrayList<Notice> NoticeList;

    @Override
    public void setView(IctNoticeContract.View v) {
        activity=(IctNoticeActivity)v;
    }

    @Override
    public void fetch(final int id) {
        this.id = id;
        String url = Data.getUrl()[id];
        queue =BaseApplication.getRequestQueue();
        activity.setVisibility(false);

        result = new StringBuffer("");


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("responseREQUESTQUEUE", response);
                        Document doc = Jsoup.parse(response);
                        result.append(response);
                        element = doc.select(Data.getQuery()[id]);
                        NoticeList = new ArrayList<>();
                        for (int i = 0; i < element.size(); i++) {
                            Notice notice = new Notice();
                            //notice.setTitle(element.get(i).text());
                            String title=element.get(i).select("a").text();
                            if(title.length()>48){
                                title=title.substring(0,44);
                                title=title.concat("...");
                            }
                            notice.setTitle(title);
                            // Log.d("get judge", "judge:" + element.get(i).text().length() + "|");

                            if (element.get(i).text().length() < 5) {
                                String tmp = (Jsoup.parse(element.get(i).toString()).select("a").html());
                                tmp=tmp.split("</")[0];
                                if(tmp.length()>48){
                                    tmp=tmp.substring(0,44);
                                    tmp=tmp.concat("...");
                                }
                                notice.setTitle(tmp);
                                //Log.d("parsing fail?", "failed");
                            }

                            if (id < 5) {
                                notice.setLink(element.get(i).select("a").attr("href"));
                                Log.d("listLink", element.get(i).select("a").attr("href"));
                                notice.setJudge(true);
                                // notice.setDate(doc.select("td").get(i*6+4).text());
                            } else
                                notice.setLink(Data.getUrl()[id]);
                            notice.setDate("2017");


                            NoticeList.add(notice);

                        }
                        //Log.d("fetched",tag);
                        NoticeAdapter adapter = new NoticeAdapter();
                        adapter.setNoticeList(NoticeList);
                        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(activity.getApplicationContext(), NoticeDetailActivity.class);
                                intent.putExtra("link", NoticeList.get(position).getLink());
                                Log.d("linkOnItemClick",NoticeList.get(position).getLink());
                                intent.putExtra("title", NoticeList.get(position).getTitle());
                                Log.d("titleOnItemClick",NoticeList.get(position).getTitle());
                                intent.putExtra("getAble", NoticeList.get(position).getJudge());
                                activity.startActivity(intent);
                            }
                        });
                        activity.setNoticeAdapter(adapter);
                        activity.onClick(adapter.getOnItemClickListener());
                        activity.setVisibility(true);
                        //Log.d("selected elements", element.toString());

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        result.append("error");
                        //Log.d("responseREQUESTQUEUE", "error");
                    }
                }
        );
        //Log.d("stringREQ", stringRequest.toString());
        queue.add(stringRequest);
    }
    @Override
    public NoticeAdapter getNoticeAdapter() {
        return null;
    }
}
