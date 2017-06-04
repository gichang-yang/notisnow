package com.notisnow.anonimous.notisnow.UI.NoticeDeail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.notisnow.anonimous.notisnow.R;

public class NoticeDetailActivity extends AppCompatActivity implements NoticeDetailContract.View
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);
    }
}
