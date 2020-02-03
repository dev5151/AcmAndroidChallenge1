package com.acmvit.androidchallenge1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acmvit.androidchallenge1.Models.Item;
import com.acmvit.androidchallenge1.Models.Utils;
import com.acmvit.androidchallenge1.R;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Objects;


public class load_image_activity extends AppCompatActivity {
    WebView view;
    Item item;
    ArrayList<Item> items;
    View v;
    EditText t, d;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image_activity);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Select Images");

        items = Utils.getArrayobj().list;
        view = findViewById(R.id.webview);
        view.loadUrl("https://www.google.com/");
        view.canGoBack();
        item = new Item();
        view.setWebViewClient(new MyBrowser());
        v = findViewById(R.id.form);
        t = findViewById(R.id.form_title);
        d = findViewById(R.id.form_disp);
        btn = findViewById(R.id.load_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = btn.getText().toString();
                switch (text){
                    case "Add image":
                        String url = load_image_activity.this.view.getUrl();
                        checkimg(url);
                        break;
                    case "Add":
                        add();
                }

            }
        });

    }

    private void checkimg(final String url){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URLConnection urlConnection = new URL(url).openConnection();
                    String content_type = urlConnection.getContentType();
                    if (content_type.startsWith("image/")) {
                        Log.d("URL", url);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                item.setUrl(url);
                                Log.d("SIZE", String.valueOf(items.size()));
                                btn.setText("Add");
                                TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.rl), new Slide().setDuration(800));
                                v.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                    else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(load_image_activity.this, "Selected type not an image", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
    }

    private void add(){
        String title = t.getText().toString();
        String body = d.getText().toString();
        if(!(title.equals("") || body.equals(""))){
            item.setTitle(title);
            item.setDisp(body);
            items.add(item);
            AmitKrishnaActivity.adapter.notifyDataSetChanged();
            Intent intent = new Intent(load_image_activity.this, AmitKrishnaActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
        }
        else {
            Toast.makeText(load_image_activity.this, "Above Fields cannot be empty", Toast.LENGTH_SHORT).show();
        }

    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
