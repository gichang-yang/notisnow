package com.notisnow.anonimous.notisnow.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.Adapter.MajorAdapter;
import com.notisnow.anonimous.notisnow.Adapter.NoticeAdapter;
import com.notisnow.anonimous.notisnow.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

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
                    //noticeAdapter = new NoticeAdapter();
                    //listView.setAdapter(noticeAdapter);
                    presenter.getNoticeList(0);

                    return true;

                case R.id.navigation_software:

                    noticeAdapter = new NoticeAdapter();
                    listView.setAdapter(noticeAdapter);
                    return true;

                case R.id.navigation_mechanical:
                    noticeAdapter = new NoticeAdapter();
                    listView.setAdapter(noticeAdapter);
                    return true;

                case R.id.navigation_ict:

                    listView.setAdapter(adapter);
                    return true;

                case R.id.navigation_chemistry:

                    noticeAdapter = new NoticeAdapter();
                    listView.setAdapter(noticeAdapter);

                    return true;

            }
            return false;
        }

    };

    public void setNoticeAdapter(NoticeAdapter adapter){
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.setView(this);;



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);


        adapter = new MajorAdapter();
        listView = (ListView) findViewById(R.id.totallist);

//        presenter.getNoticeList(0);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        adapter.notifyDataSetChanged();
    }

    @Override
    public Context getContext() {

        return getApplicationContext();
    }
}
