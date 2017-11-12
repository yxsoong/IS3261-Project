package com.yxsoong.project.androidacademy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 12/11/2017.
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    private Context context;
    public MainRecyclerAdapter(){

    }

    private String[] titles = {"Getting Started", "Lesson One: Layouts", "Lesson Two: Input Controls", "Lesson Three: Switching Pages", "Lesson Four: Fragments", "Test Your Skills"};

    private int[] images = {R.drawable.creation, R.drawable.book_open_page_variant, R.drawable.book_open_page_variant, R.drawable.book_open_page_variant, R.drawable.book_open_page_variant, R.drawable.book_open_page_variant};

    private int arrowImage = R.drawable.chevron_right;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_menu_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemImage.setImageResource(images[position]);
        holder.title.setText(titles[position]);
        holder.arrow.setImageResource(arrowImage);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public static final int REQUEST_CODE = 1;
        public int currentItem;
        public ImageView itemImage;
        public TextView title;
        public ImageView arrow;

        public ViewHolder(View itemView){
            super(itemView);
            itemImage = itemView.findViewById(R.id.itemImage);
            title = itemView.findViewById(R.id.itemTextView);
            arrow = itemView.findViewById(R.id.itemArrow);

            itemView.setOnClickListener(new View.OnClickListener() {
                Intent myIntent;
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position){
                        case 0:
                            myIntent = new Intent(context, GettingStartedActivity.class);
                            //context.startActivity(myIntent);
                            ((Activity)context).startActivityForResult(myIntent, REQUEST_CODE);

                            break;
                        case 1:
                            myIntent = new Intent(context, Lesson1Activity.class);
                            context.startActivity(myIntent);
                            break;
                    }

                }
            });
        }
    }
}
