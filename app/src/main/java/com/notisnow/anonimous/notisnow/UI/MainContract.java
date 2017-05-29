package com.notisnow.anonimous.notisnow.UI;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 28..
 */

public interface MainContract {
    interface View{

    }

    interface Presenter{
        void setView(View v);
        ArrayList<String> getNoticeList(int id);

    }
}
