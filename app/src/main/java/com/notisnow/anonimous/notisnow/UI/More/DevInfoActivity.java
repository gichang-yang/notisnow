package com.notisnow.anonimous.notisnow.UI.More;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.notisnow.anonimous.notisnow.R;

public class DevInfoActivity extends AppCompatActivity implements MoreContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_info);
    }
}
