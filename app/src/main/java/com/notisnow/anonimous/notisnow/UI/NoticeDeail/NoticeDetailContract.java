package com.notisnow.anonimous.notisnow.UI.NoticeDeail;

import android.webkit.WebView;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public interface NoticeDetailContract {
    interface View{
        WebView getWebView();
    }

    interface Presenter{
        void setView(View v);
        void fetch(String url);
    }
}
