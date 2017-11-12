package com.yxsoong.project.androidacademy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 13/11/2017.
 */

public class LessonRecyclerAdapter extends RecyclerView.Adapter<LessonRecyclerAdapter.ViewHolder> {

    private Context context;
    private String[] titles;
    private String[] descriptions;
    private int[] images;
    private Class[] classes;
    private int arrowImage = R.drawable.chevron_right;

    public LessonRecyclerAdapter(){

    }

    public LessonRecyclerAdapter(String[] titles, String[] descriptions, int[] images, Class[] classes){
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
        this.classes = classes;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position == titles.length - 1){
           CardView cardView = (CardView) holder.row.getParent();
           cardView.setCardBackgroundColor(context.getColor(R.color.gold));
        }
        holder.itemImage.setImageResource(images[position]);
        holder.itemTitle.setText(titles[position]);
        holder.itemDescription.setText(descriptions[position]);
        holder.arrow.setImageResource(arrowImage);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public int currentItem;
        RelativeLayout row;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDescription;
        public ImageView arrow;


        public ViewHolder(View itemView){
            super(itemView);
            row = itemView.findViewById(R.id.itemRow);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            arrow = itemView.findViewById(R.id.itemArrow);

            itemView.setOnClickListener(new View.OnClickListener() {
                Intent myIntent;
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if(position == getItemCount() - 1){
                        myIntent = new Intent(context, classes[position]);
                        context.startActivity(myIntent);
                    } else{
                        switch (position){
                            case 0:
                                myIntent = new Intent(context, classes[position]);
                                context.startActivity(myIntent);
                                break;
                            case 1:
                                myIntent = new Intent(context, classes[position]);
                                context.startActivity(myIntent);
                                break;
                            default:
                                Toast.makeText(context, "Working in progress.", Toast.LENGTH_LONG);
                        }
                    }


                }
            });
        }
    }
}
