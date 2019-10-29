package com.gykotizm.gunesimol;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.VideoView;

public class AcilisEkrani extends Activity {
    private static int gosterim_suresi = 9000;
    VideoView videoView;
    Uri adres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acilisekrani);
        videoView = (VideoView) findViewById(R.id.acilis_video);
        adres = Uri.parse("android.resource://" + getPackageName()
                + "/"
                + R.raw.acilisekrani);
        videoView.setVideoURI(adres);
        videoView.start();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(AcilisEkrani.this, Login.class);
                startActivity(i);

                finish();
            }
        }, gosterim_suresi);
    }
}
