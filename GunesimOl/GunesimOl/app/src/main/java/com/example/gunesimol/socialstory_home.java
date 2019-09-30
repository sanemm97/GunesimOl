package com.example.gunesimol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class socialstory_home extends Fragment {
    Button btn_newsocialstory,btn_socialstory_recordings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.socialstory_home,container,false);
        btn_newsocialstory=view.findViewById(R.id.btn_newsocialstory);
        btn_socialstory_recordings=view.findViewById(R.id.btn_socialstory_recordings);
        btn_socialstory_recordings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSocialStories();
            }

            private void openSocialStories() {
                MyListener listener= (MyListener) getActivity();
                listener.openSocialStories();
            }
        });
        btn_newsocialstory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newStory();
            }

            private void newStory() {
                MyListener listener= (MyListener) getActivity();
                listener.newStory();
            }
        });



        return view;
    }
}