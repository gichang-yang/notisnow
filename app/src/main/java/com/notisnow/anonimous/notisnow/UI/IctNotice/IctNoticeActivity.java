package com.notisnow.anonimous.notisnow.UI.IctNotice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.R;

public class IctNoticeActivity extends AppCompatActivity implements IctNoticeContract.View{
    RelativeLayout tmpLayout;
    ListView listView;
    NoticeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ict_notice);

        listView = (ListView) findViewById(R.id.totallist);
        tmpLayout = (RelativeLayout) findViewById(R.id.tmpView);

        adapter = new NoticeAdapter();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void setVisibility(boolean judge) {
        if (judge == true) {
            listView.setVisibility(View.VISIBLE);
            tmpLayout.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.GONE);
            tmpLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setNoticeAdapter(NoticeAdapter adapter) {

    }
}
