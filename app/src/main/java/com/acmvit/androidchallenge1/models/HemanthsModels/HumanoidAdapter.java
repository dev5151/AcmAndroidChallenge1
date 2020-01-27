package com.acmvit.androidchallenge1.models.HemanthsModels;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.acmvit.androidchallenge1.R;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class HumanoidAdapter extends RecyclerView.Adapter<HumanoidAdapter.HumanoidViewHolder> {

    List<HumanoidData> humanoids;

    public HumanoidAdapter(List<HumanoidData> humanoids) {
        this.humanoids = humanoids;
    }

    @NonNull
    @Override
    public HumanoidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_hemanth, parent, false);
        HumanoidViewHolder humanoidViewHolder = new HumanoidViewHolder(v);
        return humanoidViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HumanoidViewHolder holder, int position) {
        holder.humanoidTitle.setText(humanoids.get(position).name);
        holder.humanoidReleased.setText(humanoids.get(position).released);
        //HumanoidViewHolder.HumanoidPhotoPhoto.setImageResource(persons.get(i).photoId);
        try {
            Glide.with(holder.humanoidPhoto.getContext())
                    .load(humanoids.get(position).imgLinko)
                    .centerCrop()
                    .override(300,300)
                    .into((holder).getImage());
        }catch(Exception e){
            Log.e("ERROR",e.toString());
        }
    }

    @Override
    public int getItemCount() {
        return humanoids.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class HumanoidViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView humanoidTitle;
        TextView humanoidReleased;
        ImageView humanoidPhoto;

        HumanoidViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_hemanth_model);
            humanoidTitle = (TextView) itemView.findViewById(R.id.title_hemanth_model);
            humanoidReleased = (TextView) itemView.findViewById(R.id.released_hemanth_model);
            humanoidPhoto = (ImageView) itemView.findViewById(R.id.image_hemanth_model);
        }
        public ImageView getImage() {
            return humanoidPhoto;
        }
    }


}
