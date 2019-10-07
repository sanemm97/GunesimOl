package com.example.gunesimol;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class SocialStoryVideos extends AppCompatActivity {
    private VideoView videoView;
    Button btn_video;
    Uri adres;
    int videonumara=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sosyal Öykü Eğitim Seti");
        setContentView(R.layout.socialstory_videos);
        btn_video=findViewById(R.id.btn_playVideo);
        videoView = (VideoView) findViewById(R.id.video_view);
        Bundle bundle = getIntent().getExtras();
        videonumara = bundle.getInt("videonumara");
        if(videonumara==1)
        {
            adres = Uri.parse("android.resource://" + getPackageName()
                    + "/"
                    + R.raw.video1);
            getSupportActionBar().setTitle("Sosyal Öykü Nedir? Nerelerde Kullanılır?");

        }
        else if (videonumara==2)
        {
            adres = Uri.parse("android.resource://" + getPackageName()
                    + "/"
                    + R.raw.video2);
            getSupportActionBar().setTitle("Sosyal Öykü Yazmak İçin Kullanılan Cümle Çeşitleri Nelerdir?");

        }
        else if (videonumara==3)
        {
            adres = Uri.parse("android.resource://" + getPackageName()
                    + "/"
                    + R.raw.video3);
            getSupportActionBar().setTitle("Sosyal Öykü Nasıl Yazılır?");

        }
        else if (videonumara==4)
        {
            adres = Uri.parse("android.resource://" + getPackageName()
                    + "/"
                    + R.raw.video4);
            getSupportActionBar().setTitle("Sosyal Öykü Ne Zaman Geri Çekilir?");
        }

        videoView.setVideoURI(adres);
        btn_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(videoView.isPlaying())
                {
                    btn_video.setBackgroundResource(R.drawable.btn_playvideo);
                    videoView.pause();


                }
                else {

                    btn_video.setBackgroundResource(R.drawable.btn_pausevideo);
                    videoView.start();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        videoView.start();
    }
}
