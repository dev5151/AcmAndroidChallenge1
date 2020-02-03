package com.acmvit.androidchallenge1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acmvit.androidchallenge1.Models.Item;
import com.acmvit.androidchallenge1.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AmitKrishnaAdapter extends RecyclerView.Adapter<AmitKrishnaAdapter.VH> {
    private Context mContext;
    private ArrayList<Item> marrayList;

    public AmitKrishnaAdapter(Context context, ArrayList<Item> arrayList) {
        mContext = context;
        marrayList = arrayList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amit_krishna_item_layout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Item item = marrayList.get(position);
        Glide.with(mContext).load(item.getUrl())
        .into(holder.image);
        holder.title.setText(item.getTitle());
        holder.body.setText(item.getDisp());
    }

    @Override
    public int getItemCount() {
        return marrayList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, body;
        public VH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            body = itemView.findViewById(R.id.item_body);
            image = itemView.findViewById(R.id.item_image);
        }


    }
}

    /*
    You will have to extend this class as a Recycler View Adapter, create a view holder and write the custom code.....
     */
