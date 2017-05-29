package com.notisnow.anonimous.notisnow.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.notisnow.anonimous.notisnow.Item.MajorItem;
import com.notisnow.anonimous.notisnow.R;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class MajorAdapter extends BaseAdapter {


    String[] majorArray={"전자공학전공","응용물리학과","it공학전공"};
    int[] majImgIdArray={R.drawable.major_electron,R.drawable.major_physics,R.drawable.major_it};
    Context context;


    public Context setContext(Context context){
        return context;
    }
    public MajorAdapter(Context context){
        this.context=context;

    }
    public MajorAdapter(){

    }


    @Override
    public int getCount() {
        return 3;
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
        Log.d("position",""+position);
        MajorItem item;
        if (convertView == null) item = new MajorItem(parent.getContext());
        else item = (MajorItem) convertView;
        item.setMajorImage(majImgIdArray[position]);
        item.setTitle(majorArray[position]);

        return item;
    }
}
