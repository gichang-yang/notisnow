package com.notisnow.anonimous.notisnow.Model;

import com.notisnow.anonimous.notisnow.UI.MainContract;

/**
 * Created by yang-gichang on 2017. 5. 30..
 */

public class Notice implements MainContract.Model {
    private String title;
    private String date;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDate(String date) {
        this.date = date;

    }
}
