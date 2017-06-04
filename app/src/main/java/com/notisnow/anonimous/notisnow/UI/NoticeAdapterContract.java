package com.notisnow.anonimous.notisnow.UI;

import android.widget.AdapterView;

import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.Model.Notice;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 30..
 */

public interface NoticeAdapterContract {
    interface NoticeItemSelectedListener{
        void onItemClick(android.view.View itemView, NoticeAdapter adapter, int position);
    }


    interface View {

    }

    interface Model {


        void setOnItemClickListener(AdapterView.OnItemClickListener listener);
        void setNoticeList(ArrayList<Notice> list);
        AdapterView.OnItemClickListener getOnItemClickListener();
        Notice getItem(int position);
    }



}
