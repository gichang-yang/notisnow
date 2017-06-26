package com.notisnow.anonimous.notisnow.UI.Intro;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.R;

public class IntroActivity extends AppCompatActivity implements IntroContract.View{
    Handler handler;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        textView=(TextView)findViewById(R.id.progress);
        handler= new Handler(){

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                    textView.setText("("+msg.what+"%)");

            }
        };
        IntroContract.Presenter presenter = new IntroPresenter(this);
        presenter.await();

    }

    @Override
    public void startActivity() {
        ((IntroActivity)this).finish();
    }

    @Override
    public void UpdateProgress(int progress) {
        handler.sendEmptyMessage(progress);
    }
}
