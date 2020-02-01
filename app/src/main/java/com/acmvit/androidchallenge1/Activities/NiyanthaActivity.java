package com.acmvit.androidchallenge1.Activities;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.acmvit.androidchallenge1.Adapters.NiyanthaAdapter;
import com.acmvit.androidchallenge1.R;
import java.util.ArrayList;

public class NiyanthaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niyantha);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.rb));
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#331100")));
        final ArrayList<RoadBike_niyantha> roadBike = new ArrayList<RoadBike_niyantha>();
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/tpE7ydvZEB87BK2igxNWBP-1920-80.jpg", "SPECIALIZED ROUBAIX ELITE",
                    "The most comfortable race bike and hence, for many riders, the best", "https://www.t3.com/reviews/specialized-roubaix-sport-review"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/rSSkDm3kbRwjEAcEQP2Gbe-1920-80.jpg", "CANYON ROADLITE CF 8.0\n",
                    "Best road bike/urban commute bike hybrid", "https://www.canyon.com/en-gb/fitness/roadlite/roadlite-cf-8-0.html"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/U5qG3XKpsynxRMU54Wwf85-1920-80.jpg", "EDDY MERCKX SANREMO76 ULTEGRA\n",
                    "Race winning pedigree at a relatively affordable price", "https://www.t3.com/news/tour-de-france-road-bikes-to-buy"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/xsr4UoV4rJX9n9JobDD9yN-1920-80.jpg", "FELT AR5\n",
                    "A performance focussed machine for racing or speedy commutes", "https://feltbicycles.com/pages/road"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/GCfaBMjR7ccQGCAmDSqbY7-1920-80.jpg", "SPECIALIZED TARMAC DISC SPORT",
                    "Not cheap, but this is one of the fastest and most reliable road bikes around", "https://www.specialized.com/us/en/tarmac"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/m5dkfcDYYxqUm6CS9QjRXY-1920-80.jpg", "CANNONDALE SUPERSIX EVO 105\n",
                    "Best VFM road bike frame", "https://www.cannondale.com/en-us/bikes/road/race/supersix-evo"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/HLz8Z5PCb7cSUUWN2tZznb-1920-80.jpg", "GIANT DEFY ADVANCED 3 (2017)\n",
                    "Another great road bike for those who value a bit of comfort", "https://www.giant-bicycles.com/us/bikes-defy-advanced-2020"));
            roadBike.add(new RoadBike_niyantha("https://cdn.mos.cms.futurecdn.net/kbPsZmwFaG2BmqCKt9epeb-1920-80.jpg", "CANYON ULTIMATE CF SL DISC 8.0\n",
                    "Another great value road warrior from Deutschland", "https://www.canyon.com/en-in/road-bikes/race-bikes/ultimate/ultimate-cf-sl-disc-8.0/2157.html"));

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        NiyanthaAdapter adapter=new NiyanthaAdapter(this,roadBike);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

}
