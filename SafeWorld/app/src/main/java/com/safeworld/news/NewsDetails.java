package com.safeworld.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.safeworld.R;

import androidx.appcompat.app.AppCompatActivity;
/**
 * The NewsDetails class use for displaying detail of the news or article content
 * @author nieruize
 * @version 1.0
 */
public class NewsDetails extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        getSupportActionBar().hide();

        // using the web view to display the content
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();

        // get the url from intent
        String url = intent.getStringExtra("url");

        // common setting for using web view
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());

        // send the url request
        webView.loadUrl(url);

    }
}
