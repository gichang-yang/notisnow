package com.notisnow.anonimous.notisnow.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.R;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */


public class MajorItem extends LinearLayout {
    TextView title;
    ImageView majorImage;
    Context context;



    public TextView getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public ImageView getMajorImage() {
        return majorImage;
    }

    public void setMajorImage(int majorImage) {
        this.majorImage.setImageResource(majorImage);
    }

    public MajorItem(Context context) {
        super(context);
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.major_item,this,true);
        majorImage=(ImageView)findViewById(R.id.majorImage);
        title=(TextView)findViewById(R.id.major);
    }
}
