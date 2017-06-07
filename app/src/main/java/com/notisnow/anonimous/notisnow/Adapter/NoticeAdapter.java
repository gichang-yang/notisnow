package com.notisnow.anonimous.notisnow.Adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.notisnow.anonimous.notisnow.Item.NoticeItem;
import com.notisnow.anonimous.notisnow.Model.Notice;
import com.notisnow.anonimous.notisnow.UI.NoticeAdapterContract;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class NoticeAdapter extends BaseAdapter implements NoticeAdapterContract.Model,NoticeAdapterContract.View{
    ArrayList<Notice> notices=new ArrayList<>();
    AdapterView.OnItemClickListener listener;


    @Override
    public int getCount() {
        Log.d("returnSize",""+notices.size());
        return notices.size();


    }


    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        this.listener=listener;
    }

    @Override
    public void setNoticeList(ArrayList<Notice> list) {
        notices=list;
    }

    @Override
    public AdapterView.OnItemClickListener getOnItemClickListener() {
        return listener;
    }

    @Override
    public Notice getItem(int position) {
        return notices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        NoticeItem item;

        if(convertView==null) item=new NoticeItem(parent.getContext());
        else item=(NoticeItem)convertView;

        String title=notices.get(position).getTitle();
        if(title.length()>44){
            title=title.replace("\n","");
            title=title.substring(0,41);
            title=title.concat("...");
            item.setTitle(title);
        }
        else item.setTitle(notices.get(position).getTitle());
        item.setDate(notices.get(position).getDate());
        return item;
    }




}
