package com.notisnow.anonimous.notisnow.UI.IctNotice;

import android.content.Context;

import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;

/**
 * Created by yang-gichang on 2017. 6. 4..
 */

public interface IctNoticeContract {
    interface View{
        Context getContext();
        void setVisibility(boolean judge);
        void setNoticeAdapter(NoticeAdapter adapter);
    }

    interface Presenter{
        void setView(View v);
        void fetch(int id);
        NoticeAdapter getNoticeAdapter();

    }

    interface Model{

    }
}
