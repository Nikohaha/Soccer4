package com.codingstuff.soccerlive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SoccerAdapter extends RecyclerView.Adapter<SoccerAdapter.SoccerHolder> {

    private Context context;
    private List<Soccer> soccerList;

    public SoccerAdapter(Context context , List<Soccer> soccers){
        this.context = context;
        soccerList = soccers;
    }
    @NonNull
    @Override
    public SoccerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item , parent , false);
        return new SoccerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoccerHolder holder, int position) {

        Soccer soccer = soccerList.get(position);
        holder.title.setText(soccer.getTitle());
        holder.date.setText(soccer.getDate());
        Glide.with(context).load(soccer.getSide1()).into(holder.side1);
//        Glide.with(context).load(soccer.getThumbnail()).into(holder.thumbnail);


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , DetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("title" , soccer.getTitle());
                bundle.putString("date" , soccer.getDate());
                bundle.putString("side1" , soccer.getSide1());
                bundle.putString("thumbnail" , soccer.getThumbnail());


                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return soccerList.size();
    }

    public class SoccerHolder extends RecyclerView.ViewHolder{

        ImageView side1, thumbnail;
        TextView title , date;
        ConstraintLayout constraintLayout;

        public SoccerHolder(@NonNull View itemView) {
            super(itemView);

            side1 = itemView.findViewById(R.id.side1);
            title = itemView.findViewById(R.id.title_i);
            date = itemView.findViewById(R.id.date_i);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            constraintLayout = itemView.findViewById(R.id.main_layout);
        }
    }
}
