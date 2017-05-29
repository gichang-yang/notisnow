package com.notisnow.anonimous.notisnow.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.R;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class NoticeItem extends LinearLayout {
    TextView title;
    TextView date;

    public NoticeItem(Context context) {
        super(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.notice_item,this,true);

        title=(TextView)findViewById(R.id.title);
        date=(TextView)findViewById(R.id.date);
    }
}
