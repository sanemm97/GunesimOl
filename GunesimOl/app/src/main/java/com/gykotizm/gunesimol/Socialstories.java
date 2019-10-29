package com.gykotizm.gunesimol;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.gykotizm.gunesimol.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Socialstories extends Fragment {
    private RecyclerView recycler_view;
    private List<Story> storyList;
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    RecyclerViewAdapter recyclerViewAdapter;
    String userid = user.getUid();
    EditText deneme;
    DatabaseReference reference=FirebaseDatabase.getInstance().getReference(userid);
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.socialstories,container,false);
        recycler_view = (RecyclerView)view.findViewById(R.id.social_recycleView);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        storyList = new ArrayList<Story>();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        myRef.child("socialstories").child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                storyList.clear();
                StoriesFirebase storiesFirebase=new StoriesFirebase();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    storiesFirebase = postSnapshot.getValue(StoriesFirebase.class);

                    storyList.add(new Story(R.drawable.story,storiesFirebase.storyTittle, storiesFirebase.storyDate,storiesFirebase.storyId ));


                }
                final RecyclerViewAdapter adapter_items = new RecyclerViewAdapter(getActivity().getApplicationContext(),storyList,getActivity() ,new ItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position) {


                    }

                });
                recycler_view.setHasFixedSize(true);
                recycler_view.setAdapter(adapter_items);
                recycler_view.setItemAnimator(new DefaultItemAnimator());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }
}
