package com.acmvit.androidchallenge1.Adapters;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.acmvit.androidchallenge1.Activities.RoadBike_niyantha;
import com.acmvit.androidchallenge1.R;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class NiyanthaAdapter extends RecyclerView.Adapter<NiyanthaAdapter.ViewHolder> {
    private ArrayList<RoadBike_niyantha> list;
    private Context context;
    public NiyanthaAdapter(Context context, ArrayList<RoadBike_niyantha> List) {
        this.context = context;
        this.list= List;
    }
    @NonNull
    @Override
    public NiyanthaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_niyantha, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getMbikeUrl()).into(holder.bikeImg);
        holder.bikeName.setText(list.get(position).getMtext());
        holder.bikeDesp.setText(list.get(position).getMdescription());
        holder.extraInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(list.get(position).getMextraInfoUrl()));
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bikeImg;
        TextView bikeName;
        TextView bikeDesp;
        TextView extraInfo;
        public ViewHolder(View view) {
            super(view);
           bikeImg = view.findViewById(R.id.image);
           bikeName= view.findViewById(R.id.title);
           bikeDesp= view.findViewById(R.id.descrip);
           extraInfo=view.findViewById(R.id.extraInfo);
        }
    }
}



