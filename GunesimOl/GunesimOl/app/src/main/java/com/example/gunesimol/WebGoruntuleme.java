package com.example.gunesimol;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebGoruntuleme extends AppCompatActivity {
    private WebView webView;
    String adres;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Otizm Spekturum Bozukluğu Nedir?");
        setContentView(R.layout.webgoruntuleme);
        webView=findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        Bundle veri_al = getIntent().getExtras();
        adres = veri_al.getString("adres");
        webView.loadUrl(adres);


    }
}
