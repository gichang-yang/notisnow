package com.notisnow.anonimous.notisnow.Model;

/**
 * Created by yang-gichang on 2017. 6. 24..
 */

public class LibraryItem {
    String url;
    String Title;

    public LibraryItem(String title,String url){
        this.url=url;
        this.Title=title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
