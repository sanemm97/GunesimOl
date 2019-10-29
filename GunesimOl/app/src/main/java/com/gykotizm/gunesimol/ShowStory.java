package com.gykotizm.gunesimol;


import android.content.ActivityNotFoundException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.gykotizm.gunesimol.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowStory extends AppCompatActivity {
    TextView txt_Story, txt_target, txt_tittle;
    String story_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.showstory);
        txt_Story=findViewById(R.id.txt_Story);
        txt_target=findViewById(R.id.txt_target);
        txt_tittle=findViewById(R.id.txt_tittle);
        Bundle intent = getIntent().getExtras();
        story_id = intent.getString("story_id");


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userid = user.getUid();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("socialstories").child(userid).child(story_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    StoriesFirebase storiesFirebase = new StoriesFirebase();
                    storiesFirebase = dataSnapshot.getValue(StoriesFirebase.class);
                    getSupportActionBar().setTitle(storiesFirebase.storyTittle);
                    txt_Story.setText(storiesFirebase.storyInput + " " + storiesFirebase.storyDevelopment + " " + storiesFirebase.storyResult);
                    txt_tittle.setText(storiesFirebase.storyTittle);
                    txt_target.setText(storiesFirebase.storyTarget);
                    getSupportActionBar().setTitle(storiesFirebase.storyTittle);
                }
                catch (ActivityNotFoundException hata)
                {
                    Toast.makeText(getApplicationContext(),"Hata: . \n"+hata.getMessage(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ShowStory.this,"Bir hata ile karşılaşıldı \n"+databaseError.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
