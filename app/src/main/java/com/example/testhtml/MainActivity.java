package com.example.testhtml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        webView= (WebView) findViewById(R.id.welcome_webView);
        webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.requestFocus();
        //加载指定url的html界面
//        webView.loadUrl("http://www.baidu.com");
        //加载asset文件中的的html界面
        webView.loadUrl("file:///android_asset/html/welcome.html");
        //加载本地sd卡中的html界面
//        webView.loadUrl("content://com.android.appshare/sdcard/aaa.htm");

        //使用webView显示浏览的网页
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if(url!=null){
                    view.loadUrl(url);
                }
                return true;
            }
        });
    }


}
