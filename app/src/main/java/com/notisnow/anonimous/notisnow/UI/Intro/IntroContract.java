package com.notisnow.anonimous.notisnow.UI.Intro;

/**
 * Created by yang-gichang on 2017. 6. 8..
 */

public interface IntroContract {
    interface View{
        void startActivity();
        void UpdateProgress(int progress);
    }

    interface Presenter{
        void await();
    }
}
