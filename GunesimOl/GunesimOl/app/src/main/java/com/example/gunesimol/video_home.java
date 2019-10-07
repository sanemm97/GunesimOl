package com.example.gunesimol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Video_home extends AppCompatActivity  {
    Button video1,video2,video3,video4;
    Intent intent=new Intent();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Sosyal Öykü Eğitim Seti");
        setContentView(R.layout.video_home);
        video1=findViewById(R.id.video1);
        video2=findViewById(R.id.video2);
        video3=findViewById(R.id.video3);
        video4=findViewById(R.id.video4);
        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder(1);
            }
        });
        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder(2);
            }
        });
        video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder(3);
            }
        });
        video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gonder(4);
            }
        });

    }


    private void gonder(int video) {

        intent.setClass(getApplicationContext(),SocialStoryVideos.class);
        intent.putExtra("videonumara",video);
        startActivity(intent);

    }
}
