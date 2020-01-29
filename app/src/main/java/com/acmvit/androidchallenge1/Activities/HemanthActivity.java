package com.acmvit.androidchallenge1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.acmvit.androidchallenge1.R;
import com.acmvit.androidchallenge1.models.HemanthsModels.HumanoidAdapter;
import com.acmvit.androidchallenge1.models.HemanthsModels.HumanoidData;

import java.util.ArrayList;
import java.util.List;

public class HemanthActivity extends AppCompatActivity {
    public List<HumanoidData> andros;
    private Menu mMenu;

    public boolean isViewWithStag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
        getSupportActionBar().setTitle("Evolution of Android");
        setContentView(R.layout.activity_hemanth);
        initData();
        int resId = R.anim.layout_anim;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);

        RecyclerView rv_hem = (RecyclerView)findViewById(R.id.rv_hemanth);
        LinearLayoutManager rvLayoutManagerHem = new LinearLayoutManager(this);
        rv_hem.setLayoutAnimation(animation);
        rv_hem.setLayoutManager(rvLayoutManagerHem);
        HumanoidAdapter adapter = new HumanoidAdapter(andros,isViewWithStag,this);
        rv_hem.setAdapter(adapter);
    }

    public void initData(){
        andros = new ArrayList<>();
        andros.add(new HumanoidData("Apple Pie","September 23, 2008","http://www.icons101.com/icon_png/size_128/id_83000/Android_10_Apple_pie.png"));
        andros.add(new HumanoidData("Cupcake","April 27, 2009","http://www.icons101.com/icon_png/size_128/id_83003/Android_15_Cupcake.png"));
        andros.add(new HumanoidData("Donut","September 15, 2009","http://www.icons101.com/icon_png/size_128/id_83004/Android_16_Donut.png"));
        andros.add(new HumanoidData("Eclair","October 26, 2009","http://www.icons101.com/icon_png/size_128/id_83005/Android_20_Eclair.png"));
        andros.add(new HumanoidData("Froyo","May 20, 2010","http://www.icons101.com/icon_png/size_128/id_83006/Android_22_Froyo.png"));
        andros.add(new HumanoidData("Gingerbread","December 6, 2010","http://www.icons101.com/icon_png/size_128/id_83007/Android_23_Gingerbread.png"));
        andros.add(new HumanoidData("Honeycomb","February 22, 2011 ","http://www.icons101.com/icon_png/size_128/id_83008/Android_30_Honeycomb.png"));
        andros.add(new HumanoidData("Ice-Cream Sandwhich","October 18, 2011 ","http://www.icons101.com/icon_png/size_128/id_83009/Android_40_Icecream_sandwich.png"));
        andros.add(new HumanoidData("Jellybean","July 9, 2012 ","http://www.icons101.com/icon_png/size_128/id_83010/Android_41_Jellybean.png"));
        andros.add(new HumanoidData("Kitkat","October 31, 2013 ","http://www.icons101.com/icon_png/size_128/id_83011/Android_44_KitKat.png"));
        andros.add(new HumanoidData("Lollipop","November 12, 2014 ","http://www.icons101.com/icon_png/size_128/id_83012/Android_50_Lollipop.png"));
        andros.add(new HumanoidData("Marshmallow","October 5, 2015 ","https://pngriver.com/wp-content/uploads/2018/04/Download-Android-Marshmallow-Logo-PNG.png"));
        andros.add(new HumanoidData("Noughat","August 22, 2016 ","https://ibin.co/w800/5AIJW1N36nT9.png"));
        //andros.add(new HumanoidData("Noughat","August 22, 2016 ","https://serving.photos.photobox.com/871726257b3cf519344862b8ff95a0feb9eac626589a3b65e80f954c1b890958f6b91f42.jpg"));
        andros.add(new HumanoidData("Oreo","August 21, 2017 ","https://upload.wikimedia.org/wikipedia/commons/thumb/2/26/Android_Oreo_8.1_logo.svg/768px-Android_Oreo_8.1_logo.svg.png"));
        andros.add(new HumanoidData("Pie","August 6, 2018 ","https://ibin.co/5AIJgdWhNu2V.png"));
            andros.add(new HumanoidData("Android Ten","September 3, 2019 ","https://ibin.co/w800/5AIIeJsT7cCR.png"));





    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        mMenu = menu;
        changeMenuIcon(isViewWithStag);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_grid:
                supportInvalidateOptionsMenu();
                isViewWithStag = !isViewWithStag;
                HumanoidAdapter adapter = new HumanoidAdapter(andros,isViewWithStag,this);
                RecyclerView rv_hem = (RecyclerView)findViewById(R.id.rv_hemanth);
                rv_hem.setLayoutManager(isViewWithStag ? new LinearLayoutManager(this) : new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                int resId = R.anim.layout_anim;
                LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
                rv_hem.setLayoutAnimation(animation);
                rv_hem.setAdapter(adapter);

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    private void changeMenuIcon(boolean isViewWithStag)
    {
        MenuItem item = mMenu.getItem(0);

        if(mMenu != null)
        {
            if(isViewWithStag)
            {
                item.setIcon(R.drawable.ic_grid_on);
            }
            else
            {
                item.setIcon(R.drawable.ic_view_day_24dp);
            }
        }
    }

}


