package com.notisnow.anonimous.notisnow.UI.Intro;

/**
 * Created by yang-gichang on 2017. 6. 8..
 */

public class IntroPresenter implements IntroContract.Presenter{
    IntroContract.View view;
    private int i=0;
    public IntroPresenter(IntroContract.View view) {
        this.view=view;
    }

    @Override
    public void await() {

        class Wait extends Thread {
            @Override
            public void run() {

                    try {
                        for(int i=0;i<100;i++) {
                            Thread.sleep(20);
                            view.UpdateProgress(i);
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    view.startActivity();
                   // view.UpdateProgress(1);
                    //view.startActivity();

                super.run();
            }
        }


        Wait wait=new Wait();
        wait.start();
    }
}
