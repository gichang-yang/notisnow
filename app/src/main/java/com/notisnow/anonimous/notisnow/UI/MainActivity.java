package com.notisnow.anonimous.notisnow.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.Adapter.MajorAdapter;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    RelativeLayout tmpLayout;
    private TextView mTextMessage;
    ListView listView;
    MajorAdapter adapter;
    NoticeAdapter noticeAdapter;
    MainPresenter presenter;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.getNoticeList(0);
                    return true;

                case R.id.navigation_software:
                    presenter.getNoticeList(6);
                    return true;

                case R.id.navigation_mechanical:
                    presenter.getNoticeList(4);
                    return true;

                case R.id.navigation_ict:
                    listView.setAdapter(adapter);
                    setVisibility(true);
                    return true;

                case R.id.navigation_chemistry:
                    presenter.getNoticeList(1);
                    return true;
            }
            return false;
        }

    };

    public void setNoticeAdapter(NoticeAdapter adapter) {
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.setView(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        listView = (ListView) findViewById(R.id.totallist);
        tmpLayout = (RelativeLayout) findViewById(R.id.tmpView);

        adapter = new MajorAdapter();

        presenter.getNoticeList(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        adapter.notifyDataSetChanged();
    }

    /*private AdapterView.OnItemClickListener majorListener(){

    }*/

    @Override
    public Context getContext() {

        return getApplicationContext();
    }

    public void setVisibility(boolean judge) {
        if (judge == true) {
            listView.setVisibility(View.VISIBLE);
            tmpLayout.setVisibility(View.GONE);
        } else {
            listView.setVisibility(View.GONE);
            tmpLayout.setVisibility(View.VISIBLE);
        }
    }

    public void onClick(AdapterView.OnItemClickListener listener) {
        listView.setOnItemClickListener(listener);
    }
}
