package com.notisnow.anonimous.notisnow.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.R;

/**
 * Created by yang-gichang on 2017. 6. 24..
 */

public class LibraryLayoutItem extends LinearLayout {

    TextView title;
    ImageView img;
    public LibraryLayoutItem(Context context) {
        super(context);
        init(context);
    }

    void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.library_item,this,true);
        title=(TextView)findViewById(R.id.title);
        img=(ImageView)findViewById(R.id.imageView6);
        img.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
}
