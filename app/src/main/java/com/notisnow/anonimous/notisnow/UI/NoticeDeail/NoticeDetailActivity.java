package com.notisnow.anonimous.notisnow.UI.NoticeDeail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.notisnow.anonimous.notisnow.R;

public class NoticeDetailActivity extends AppCompatActivity implements NoticeDetailContract.View
{
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        Intent receive=getIntent();
        TextView title=(TextView)findViewById(R.id.title);
        title.setText(receive.getStringExtra("title"));

        NoticeDetailPresenter presenter= new NoticeDetailPresenter();
        presenter.setView(this);
        presenter.fetch(receive.getStringExtra("link"));

        webView=(WebView)findViewById(R.id.contents);
        WebView webView=(WebView)findViewById(R.id.contents);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
    }


    @Override
    public WebView getWebView() {
        WebView webView=(WebView)findViewById(R.id.contents);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        return webView;
    }
}
