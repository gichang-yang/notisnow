package com.notisnow.anonimous.notisnow.UI;

import com.notisnow.anonimous.notisnow.Adapter.MajorAdapter;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;

/**
 * Created by yang-gichang on 2017. 5. 30..
 */

public interface MainAdapterContract {
    interface NoticeItemSelectedListener{
        void onItemClick(android.view.View itemView, NoticeAdapter adapter, int position);
    }

    interface MajorItemSelectedListener{
        void onItemClick(android.view.View itemView, MajorAdapter adapter, int position);
    }
}
