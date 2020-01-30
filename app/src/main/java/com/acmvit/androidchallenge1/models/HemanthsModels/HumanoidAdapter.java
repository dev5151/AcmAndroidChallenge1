package com.acmvit.androidchallenge1.models.HemanthsModels;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.acmvit.androidchallenge1.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class HumanoidAdapter extends RecyclerView.Adapter<HumanoidAdapter.HumanoidViewHolder> {

    List<HumanoidData> humanoids;
    public Boolean isViewWithStag;
    public Context mContext;

    public HumanoidAdapter(List<HumanoidData> humanoids,Boolean isViewWithStag,Context mContext) {
        this.humanoids = humanoids;
        this.isViewWithStag = isViewWithStag;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HumanoidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(isViewWithStag ? R.layout.model_hemanth: R.layout.model2_hemanth,parent,false);
        HumanoidViewHolder humanoidViewHolder = new HumanoidViewHolder(v);
        return humanoidViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HumanoidViewHolder holder, int position) {
        holder.humanoidTitle.setText(humanoids.get(position).name);
        holder.humanoidReleased.setText(humanoids.get(position).released);
        try {
            final ProgressBar progressBar = holder.loading;
            Glide.with(holder.humanoidPhoto.getContext())
                    .load(humanoids.get(position).imgLinko)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(mContext,"Please change your Network Operator! Your Network Operator doesn't allow access to sites!",Toast.LENGTH_LONG).show();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            progressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
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
        ProgressBar loading;

        HumanoidViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv_hemanth_model);
            humanoidTitle = (TextView) itemView.findViewById(R.id.title_hemanth_model);
            humanoidReleased = (TextView) itemView.findViewById(R.id.released_hemanth_model);
            humanoidPhoto = (ImageView) itemView.findViewById(R.id.image_hemanth_model);
            loading = (ProgressBar) itemView.findViewById(R.id.progressBar_hemanth);
        }
        public ImageView getImage() {
            return humanoidPhoto;
        }
    }


}
