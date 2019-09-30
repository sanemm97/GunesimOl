package com.example.gunesimol;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity implements MyListener{
    Intent intent=new Intent();
String story_tittle, story_giris,story_gelisme, story_sonuc;
    static String storyid;
FragmentManager manager;
private FirebaseStorage fStorage;
private Uri filePath;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().setTitle("Anasayfa");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new home()).commit();
                    return true;
                case R.id.navigation_pecs:
                    getSupportActionBar().setTitle("Pecs İletişim Sistemi");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new pecs_home()).commit();


                    return true;
                case R.id.navigation_socialstory:
                    getSupportActionBar().setTitle("Sosyal Öyküler");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new socialstory_home()).commit();
                    return true;
                case R.id.navigation_video:
                    getSupportActionBar().setTitle("Beceri Video Havuzu");
                    getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new video_home()).commit();
                    return true;
            }
            return true;
        }
    };

    @Override

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new home()).commit();
            getSupportActionBar().setTitle("Ana Sayfa");
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void saveDataStory(String tittle, String giris, String gelisme, String sonuc, Uri image) {
        getSupportActionBar().setTitle("Sosyal Öyküler");
        story_tittle=tittle;
        story_giris=giris;
        story_gelisme=gelisme;
        story_sonuc=sonuc;
        filePath=image;
       // getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new socialstory_form()).commit();

    }

    @Override
    public void saveStory(boolean deger) {
        if(deger)
        {



        }
        else {

            /*newsocialstory newsocialstory=new newsocialstory();
           /* socialstory_home.setDataActivity(story_tittle,story_giris,story_gelisme,story_sonuc);
            Bundle bundle=new Bundle();
            bundle.putString("story_tittle",story_tittle);
            newsocialstory.setArguments(bundle);

            Toast.makeText(this, "Lütfen hikayenizi belirtilen maddelere göre düzenleyiniz.", Toast.LENGTH_LONG).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new newsocialstory()).commit();
            verilerin aynen geri gitmesi */
        }
    }

    @Override
    public void newStory() {
        getSupportActionBar().setTitle("Yeni Sosyal Öykü Oluştur");
        intent.setClass(getApplicationContext(), NewSocialStory.class);
        startActivity(intent);

    }
    public void openSocialStories()
    {
        getSupportActionBar().setTitle("Sosyal Öykülerim");
        getSupportFragmentManager().beginTransaction().replace(R.id.blank_layout,new socialstories()).commit();
    }



}
