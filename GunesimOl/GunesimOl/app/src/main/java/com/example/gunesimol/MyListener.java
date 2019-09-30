package com.example.gunesimol;

import android.net.Uri;

public interface MyListener {
     void saveDataStory(String tittle, String giris, String gelisme, String sonuc, Uri image);
     void saveStory(boolean deger);
     void newStory();

    void openSocialStories();

    
}
