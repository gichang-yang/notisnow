package com.notisnow.anonimous.notisnow.UI.More;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.notisnow.anonimous.notisnow.Item.LibraryLayoutItem;
import com.notisnow.anonimous.notisnow.Model.LibraryItem;
import com.notisnow.anonimous.notisnow.R;
import com.notisnow.anonimous.notisnow.staticField.Data;

import java.util.ArrayList;

public class OpenSourceInfoActivity extends AppCompatActivity implements MoreContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_source_info);

        final LibraryListAdapter adapter=new LibraryListAdapter();
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(adapter.getItem(position).getUrl()));
                startActivity(intent);
            }
        });


    }


    class LibraryListAdapter extends BaseAdapter{
        ArrayList<LibraryItem> list= Data.getLibList();
        LibraryLayoutItem item;
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public LibraryItem getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null) item=new LibraryLayoutItem(getApplicationContext());
            else item=(LibraryLayoutItem)convertView;
            item.setTitle(list.get(position).getTitle());

            return item;
        }
    }
}
