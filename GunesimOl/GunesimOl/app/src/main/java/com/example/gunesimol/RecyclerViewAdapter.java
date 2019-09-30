package com.example.gunesimol;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tittle,date;
        public ImageView storyImage,storyDelete,storyEdit;
        public CardView cardView;
        public MyViewHolder(View view){
            super(view);
            cardView=(CardView)view.findViewById(R.id.cardView);
            tittle=(TextView)view.findViewById(R.id.storyTittle);
            date=(TextView)view.findViewById(R.id.storyDate);
            storyImage=(ImageView)view.findViewById(R.id.storyImage);
            storyDelete=(ImageView)view.findViewById(R.id.storyDelete);
            storyEdit=(ImageView)view.findViewById(R.id.storyEdit);

            storyDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            storyEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

        }


    }

    List<Story> list_story;
    ItemClickListener listener;
    Context context;
    public RecyclerViewAdapter(Context context,List<Story> list_story, ItemClickListener listener){
        this.list_story=list_story;
        this.listener=listener;
        this.context = context;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.socialstories_list,parent,false);
        final MyViewHolder viewHolder=new MyViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,viewHolder.getPosition());
            }
        });
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){

        holder.tittle.setText(list_story.get(position).getTittle());
        holder.date.setText(list_story.get(position).getDate());
        holder.storyImage.setImageResource(list_story.get(position).getImageID());
        holder.storyDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void deleteItem(int position) {

        list_story.remove(position);
        notifyItemRemoved(position);

    }

    public void editStory(int position){
        //edit sayfasına git
        notifyItemChanged(position);
    }
    @Override
    public int getItemCount(){
        return list_story.size();
    }
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }

}
