package com.acmvit.androidchallenge1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.acmvit.androidchallenge1.Adapters.AmitKrishnaAdapter;
import com.acmvit.androidchallenge1.Models.Item;
import com.acmvit.androidchallenge1.Models.Utils;
import com.acmvit.androidchallenge1.R;

import java.util.ArrayList;

public class AmitKrishnaActivity extends AppCompatActivity {

    ArrayList<Item> items;
    static RecyclerView.Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amit_krishna);
        //Log.d("SIZE", String.valueOf(urls.size()));
        items = Utils.getArrayobj().list;
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.hasFixedSize();
        adapter = new AmitKrishnaAdapter(this, items);
        recyclerView.setAdapter(adapter);

        View view = findViewById(R.id.floatingActionButton);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AmitKrishnaActivity.this, load_image_activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

    }

}
