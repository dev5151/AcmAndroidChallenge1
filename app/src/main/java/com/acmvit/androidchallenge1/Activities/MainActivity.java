package com.acmvit.androidchallenge1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.acmvit.androidchallenge1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button henlo  = (Button) findViewById(R.id.btn_hemanth);

        henlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "HELLO!",Toast.LENGTH_LONG).show();
                Intent letsdothis = new Intent(MainActivity.this, HemanthActivity.class);
                MainActivity.this.startActivity(letsdothis);
            }
        });

        /* Steps Needed to be followed:

        1) Each of you will be working in your own Activity

        2) Use intent to switch Activity

        3) Each of you have to create a separate recycler view with a minimum of 5 items in it .

        4) Layout of Recycler View Item-
            a) Card View
            b) Title
            c) Image view
            d) Description

        5)You can choose your own topic .

        6) Use GLIDE LIBRARY TO CALL THE IMAGES FROM ANY WEBSITE

        7) Eg- You Can make a Recycler View for Super Cars .......

        8) Recycler View Adapters have to be created inside the Adapter Package.

        9) BEST OF LUCK..

        10) ENJOY...........




        */

    }
}
