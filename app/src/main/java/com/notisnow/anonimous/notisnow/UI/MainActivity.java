package com.notisnow.anonimous.notisnow.UI;

import android.content.Context;
import android.content.Intent;
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
import com.notisnow.anonimous.notisnow.UI.IctNotice.IctNoticeActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    int curId=0;
    RelativeLayout tmpLayout;
    TextView mTextMessage;
    ListView listView;
    MajorAdapter adapter;
    NoticeAdapter noticeAdapter;
    MainPresenter presenter;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.getNoticeList(0);
                    curId=0;
                    return true;

                case R.id.navigation_software:
                    presenter.getNoticeList(6);
                    curId=6;
                    return true;

                case R.id.navigation_mechanical:
                    presenter.getNoticeList(4);
                    curId=4;
                    return true;

                case R.id.navigation_ict:
                    listView.setAdapter(adapter);
                    setVisibility(true);
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getApplicationContext(), IctNoticeActivity.class);
                            intent.putExtra("linkId",adapter.getUrlId()[position]);
                            startActivity(intent);
                        }
                    });
                    return true;

                case R.id.navigation_chemistry:
                    presenter.getNoticeList(1);
                    curId=1;
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
    public void setTextViewError(Boolean judge) {
        if(judge==false)mTextMessage.setText("서버가 응답하지 않습니다");
        else mTextMessage.setText("Loading...");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage=(TextView)findViewById(R.id.textView2);
        presenter = new MainPresenter(this);
        presenter.setView(this);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        listView = (ListView) findViewById(R.id.totallist);
        tmpLayout = (RelativeLayout) findViewById(R.id.tmpView);

        adapter = new MajorAdapter();


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        presenter.getNoticeList(curId);
        adapter.notifyDataSetChanged();
    }

    /*private AdapterView.OnItemClickListener majorListener(){

    }*/

    @Override
    protected void onDestroy() {
        super.onDestroy();
        curId=1;
    }

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
