package com.notisnow.anonimous.notisnow.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.notisnow.anonimous.notisnow.Item.NoticeItem;
import com.notisnow.anonimous.notisnow.Model.Notice;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class NoticeAdapter extends BaseAdapter {
    ArrayList<Notice> notices;
    AdapterView.OnItemClickListener listener;

    @Override
    public int getCount() {
        return notices.size();
        //return notices.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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
        item.setTitle(notices.get(position).getTitle());
        item.setDate(notices.get(position).getDate());
        return item;
    }

    public void setNoticeList(ArrayList<Notice> list){
        notices=list;


    }


}
