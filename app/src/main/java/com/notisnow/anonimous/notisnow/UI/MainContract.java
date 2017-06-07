package com.notisnow.anonimous.notisnow.UI;

import android.content.Context;

import com.notisnow.anonimous.notisnow.Adapter.MajorAdapter;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.Model.Notice;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 28..
 */

public interface MainContract {
    interface View{
        Context getContext();
        void setNoticeAdapter(NoticeAdapter adapter);
        void setTextViewError(Boolean judge);
    }

    interface Presenter{
        void setView(View v);
        ArrayList<Notice> getNoticeList(int id);
        NoticeAdapter getNoticeAdapter();
        MajorAdapter getMajorAdapter();

    }

   interface Model{

   }


}
