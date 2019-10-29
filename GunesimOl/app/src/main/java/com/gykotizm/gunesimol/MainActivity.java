package com.gykotizm.gunesimol;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity implements MyListener {
    Intent veri_gonder = new Intent();
    Intent intent=new Intent();
    String story_tittle, story_giris,story_gelisme, story_sonuc;
    static String storyid;
    FragmentManager manager;
    private FirebaseAuth auth;
    private FirebaseStorage fStorage;
    private Uri filePath;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setTitle("Anasayfa");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new Home()).commit();
                    return true;
                case R.id.navigation_pecs:
                    getSupportActionBar().setTitle("Pecs İletişim Sistemi");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new Pecs_home()).commit();


                    return true;
                case R.id.navigation_socialstory:
                    getSupportActionBar().setTitle("Sosyal Öyküler");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new Socialstory_home()).commit();
                    return true;
                case R.id.navigation_uzman:
                    getSupportActionBar().setTitle("Uzman Desteği");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new UzmanDestegi()).commit();
                    return true;
                case R.id.navigation_ecizelge:
                    getSupportActionBar().setTitle("Etkinlik Çizelgeleri");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new EtkinlikCizelgesi()).commit();
                    return true;

            }
            return true;
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new Home()).commit();
            getSupportActionBar().setTitle("Ana Sayfa");
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



    @Override
    public void ShowStory(String story_id, String tittle) {
        intent.setClass(getApplicationContext(), ShowStory.class);
        intent.putExtra("story_id",story_id);
        startActivity(intent);

    }

    @Override
    public void newStory() {
        getSupportActionBar().setTitle("Yeni Sosyal Öykü Oluştur");
        intent.setClass(getApplicationContext(),NewSocialStory.class);
        startActivity(intent);


    }

    @Override
    public void openVideos() {
        getSupportActionBar().setTitle("Sosyal Öykü Eğitim Seti");
        intent.setClass(getApplicationContext(),Video_home.class);
        startActivity(intent);

    }

    public void openSocialStories()
    {
        getSupportActionBar().setTitle("Sosyal Öykülerim");
        getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new Socialstories()).commit();
    }

    @Override
    public void signOut() {
        auth.signOut();
        intent.setClass(getApplicationContext(), Login.class);
        startActivity(intent);
        finish();


    }

    @Override
    public void otizmNedir() {
        getSupportActionBar().setTitle("Otizm Spekturum Bozukluğu Nedir?");
        veri_gonder.setClass(getApplicationContext(),WebGoruntuleme.class);
        veri_gonder.putExtra("adres","https://orgm.meb.gov.tr/alt_sayfalar/otistik_cocuklar_egt_prg.html");
        startActivity(veri_gonder);

    }




}
