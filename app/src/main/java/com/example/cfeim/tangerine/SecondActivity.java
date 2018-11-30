package com.example.cfeim.tangerine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {

    private static String craigslistURL = "";

    private String item;
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            item = extras.getString("item_search");
            city = extras.getString("item_city");

            Log.d("a2", "item : " + item);
            Log.d("a2", "zipcode : " + city);
        }


    }
}
