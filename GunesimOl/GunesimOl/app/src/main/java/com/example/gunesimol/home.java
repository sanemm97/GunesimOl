package com.example.gunesimol;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends Fragment {
    Button  btn_otizm,btn_oturumuKapat;
    TextView sosyaloykusayisi;
    int sayac=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.home,container,false);
        btn_otizm=view.findViewById(R.id.btn_otizm);
        btn_oturumuKapat=view.findViewById(R.id.btn_signOut);
        sosyaloykusayisi=view.findViewById(R.id.sosyaloyku_sayisi);
        btn_oturumuKapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();

            }
        });
        btn_otizm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               otizmNedir();

            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final String userid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef.child("Socialstories").child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    sayac=sayac+1;
                }
                sosyaloykusayisi.setText(" "+String.valueOf(sayac));
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        return view;
    }


    private void otizmNedir() {
        MyListener listener= (MyListener) getActivity();
        listener.otizmNedir();
    }

    private void signOut() {
        MyListener listener= (MyListener) getActivity();
        listener.signOut();
    }
}
