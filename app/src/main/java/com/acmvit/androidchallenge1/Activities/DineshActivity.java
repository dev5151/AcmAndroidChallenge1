package com.acmvit.androidchallenge1.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.acmvit.androidchallenge1.Adapters.DineshAdapter;
import com.acmvit.androidchallenge1.R;

import java.util.ArrayList;

public class DineshActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames=new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescription=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinesh);
        getSupportActionBar().setTitle("Highest Peaks on Earth");
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://cdn.britannica.com/17/83817-050-67C814CD/Mount-Everest.jpg");
        mNames.add("Mount Everest");
        mDescription.add("         Mount Everest is Earth's highest mountain above sea level, located in the Mahalangur Himal sub-range of the Himalayas in Province No. 1 of eastern Nepal. Situated at a distance of 160 kms northeast to Kathmandu and 174 km northwest to the provincial capital of Biratnagar, the international border between Nepal and China runs across its summit point.");

        mImageUrls.add("https://cdn.cnn.com/cnnnext/dam/assets/180724163423-k2-tease-super-tease.jpg");
        mNames.add("K2 peak");
        mDescription.add("         K2, at 8,611 metres above sea level, is the second highest mountain in the world, after Mount Everest at 8,848 metres. It is located on the China–Pakistan border between Baltistan in the Gilgit-Baltistan region of northern Pakistan, and the Taxkorgan Tajik Autonomous County of Xinjiang, China.K2 is the highest point of the Karakoram range and the highest point in both Pakistan and Xinjiang.");

        mImageUrls.add("https://live.staticflickr.com/4181/33961009053_be3edca15b_b.jpg");
        mNames.add("Kangchenjunga");
        mDescription.add("         Kangchenjunga, also spelled Kanchenjunga, is the third highest mountain in the world. It rises with an elevation of 8,586 m in a section of the Himalayas called Kangchenjunga Himal delimited in the west by the Tamur River, in the north by the Lhonak Chu and Jongsang La, and in the east by the Teesta River.It lies between Nepal and Sikkim, India, with three of the five peaks (Main, Central, and South) directly on the border, and the remaining two (West and Kangbachen) in Nepal's Taplejung District.");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/7/72/Lhotse-fromChukhungRi.jpg");
        mNames.add("Lhotse");
        mDescription.add("         Lhotse is the fourth highest mountain in the world at 8,516 metres , after Mount Everest, K2, and Kangchenjunga. Part of the Everest massif, Lhotse is connected to the latter peak via the South Col. Lhotse means “South Peak” in Tibetan.");

        mImageUrls.add("https://www.dreamersdestination.com/images/packages/mt-makalu1.jpg");
        mNames.add("Makalu");
        mDescription.add("         Makalu is the fifth highest mountain in the world at 8,485 metres. It is located in the Mahalangur Himalayas 19 km southeast of Mount Everest, on the border between Nepal and Tibet Autonomous Region, China. One of the eight-thousanders, Makalu is an isolated peak whose shape is a four-sided pyramid.");

        mImageUrls.add("https://i.pinimg.com/originals/f0/ca/1f/f0ca1f7e742fc6ad6cf62d407872d373.jpg");
        mNames.add("Cho Oyu");
        mDescription.add("         Cho Oyu is the sixth-highest mountain in the world at 8,188 metres above sea level. Cho Oyu means \"Turquoise Goddess\" in Tibetan. The mountain is the westernmost major peak of the Khumbu sub-section of the Mahalangur Himalaya 20 km west of Mount Everest. The mountain stands on the China–Nepal border.");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/5/5c/Dhaulagiri_mountain.jpg");
        mNames.add("Dhaulagiri I");
        mDescription.add("         Dhaulagiri I is the seventh highest mountain in the world at 8,167 metres above sea level, and the highest mountain within the borders of a single country (Nepal). It was first climbed on 13 May 1960 by a Swiss/Austrian/Nepali expedition.");

        mImageUrls.add("https://media-cdn.tripadvisor.com/media/photo-s/11/71/ac/f4/manaslu-peak.jpg");
        mNames.add("Manaslu");
        mDescription.add("         Manaslu is the eighth highest mountain in the world at 8,163 metres above sea level. It is located in the Mansiri Himal, part of the Nepalese Himalayas, in the west-central part of Nepal. Its name, which means \"mountain of the spirit\", comes from the Sanskrit word manasa, meaning \"intellect\" or \"soul\".");

        mImageUrls.add("https://upload.wikimedia.org/wikipedia/commons/3/35/Fairy_Meadows_and_the_view_of_Nanga_Parbat.jpg");
        mNames.add("Nanga Parbat");
        mDescription.add("         Nanga Parbat , locally known as Diamer , is the ninth highest mountain in the world at 8,126 metres above sea level. Located in the Diamer District of Pakistan's Gilgit Baltistan region, Nanga Parbat is the western anchor of the Himalayas.");

        mImageUrls.add("https://www.liveabout.com/thmb/e8kwe1ib8TgKKgORmiVwyzUmAEE=/768x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-574855961-5ad9110f642dca00369e33af.jpg");
        mNames.add("Annapurna I Main");
        mDescription.add("         Annapurna I Main is the tenth highest mountain in the world at 8,091 metres above sea level, and in 1950 Maurice Herzog led a French expedition to its summit, making it the first of the eight-thousanders to be climbed.");


        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        DineshAdapter adapter = new DineshAdapter(this,mNames,mImageUrls,mDescription);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
