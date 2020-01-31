package com.acmvit.androidchallenge1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acmvit.androidchallenge1.CustomClasses.Place;
import com.acmvit.androidchallenge1.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DhaneshAdapter extends RecyclerView.Adapter<DhaneshAdapter.ViewHolder> {
    private ArrayList<Place> place;
    private Context context;

    public DhaneshAdapter(Context context, ArrayList<Place> place) {
        this.context = context;
        this.place = place;
    }

    @NonNull
    @Override
    public DhaneshAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context)
                .load(place.get(position).getmImageUrl())
                .placeholder(R.drawable.loading)
                .into(holder.img);
        holder.name.setText(place.get(position).getmName());
        holder.add.setText(place.get(position).getmAddress());
        holder.des.setText(place.get(position).getmDescription());
        holder.des_card.setVisibility(View.GONE);
        holder.direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri geolocation = Uri.parse(place.get(position).getmDirectionUri());
                Intent intent = new Intent(Intent.ACTION_VIEW, geolocation);
                context.startActivity(intent);
            }


        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.des_card.getVisibility() == View.VISIBLE) {
                    holder.des_card.setVisibility(View.GONE);
                    holder.show.setText("Show more +");
                } else {
                    holder.des_card.setVisibility(View.VISIBLE);
                    holder.show.setText("Show less +");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, add, des, show;
        View card, des_card;
        Button direction;

        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.place_image);
            name = view.findViewById(R.id.name_of_place);
            add = view.findViewById(R.id.address);
            des = view.findViewById(R.id.description);
            des_card = view.findViewById(R.id.card_description);
            card = view.findViewById(R.id.card);
            direction = view.findViewById(R.id.btn_direction);
            show = view.findViewById(R.id.show_or_hide);
        }
    }
}


