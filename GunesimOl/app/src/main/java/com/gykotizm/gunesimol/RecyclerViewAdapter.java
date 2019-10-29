package com.gykotizm.gunesimol;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gykotizm.gunesimol.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tittle,date,storyId;
        public ImageView storyImage,storyDelete,storyEdit;
        public CardView cardView;
        public MyViewHolder(View view){
            super(view);
            cardView=(CardView)view.findViewById(R.id.cardView);
            tittle=(TextView)view.findViewById(R.id.storyTittle);
            storyId=(TextView)view.findViewById(R.id.storyId);
            date=(TextView)view.findViewById(R.id.storyDate);
            storyImage=(ImageView)view.findViewById(R.id.storyImage);
            storyDelete=(ImageView)view.findViewById(R.id.storyDelete);


        }

    }

    List<Story> list_story;
    ItemClickListener listener;
    Context context;
    Activity activity;
    public RecyclerViewAdapter(Context context, List<Story> list_story, Activity activity, ItemClickListener listener){
        this.list_story=list_story;
        this.listener=listener;
        this.context = context;
        this.activity=activity;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.socialstories_list,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,viewHolder.getPosition());
                MyListener mylistener= (MyListener) activity;
                int pozisyon=viewHolder.getPosition();
                mylistener.ShowStory(list_story.get(pozisyon).getStoryId(),list_story.get(pozisyon).getTittle());
            }
        });
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){

        holder.storyId.setText(list_story.get(position).getTittle());
        holder.tittle.setText(list_story.get(position).getTittle());
        holder.date.setText(list_story.get(position).getDate());
        holder.storyImage.setImageResource(list_story.get(position).getImageID());
        holder.storyDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Hikayeniz siliniyor");
                builder.setMessage("Seçmiş olduğunuz hikayeyi silmek istediğinize emin misiniz?");
                builder.setNegativeButton("Hayır",null);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    Story story = list_story.get(position);
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        final String userid = user.getUid();
                        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("socialstories").child(userid).child(story.getStoryId());
                        dR.removeValue();
                    }
                });
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount(){
        return list_story.size();
    }
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

}
