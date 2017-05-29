package com.notisnow.anonimous.notisnow.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.notisnow.anonimous.notisnow.Item.NoticeItem;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class NoticeAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return 0;
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

        return item;
    }
}
