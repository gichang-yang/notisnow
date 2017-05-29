package com.notisnow.anonimous.notisnow.UI;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 5. 29..
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    @Override
    public void setView(MainContract.View v) {
        this.view=  v;
    }




    @Override
    public ArrayList<String> getNoticeList(int id) {
        return null;
    }


}
