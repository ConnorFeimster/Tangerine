package com.example.cfeim.tangerine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {

    private String apiKey = "Po9k2i9YAbWEjU5Kp0ey6J4ImKSKKAnrWVpXhRyPkt0CesMGE2Sw5TfATIwJ5OzF";

    private String item;
    private String zipcode;
    private int radius;

    private String city;
    private ArrayList<String> zips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            item = extras.getString("item_search");
            zipcode = extras.getString("item_zipcode");
            radius = extras.getInt("item_radius");

            Log.d("a2", "item : " + item);
            Log.d("a2", "zipcode : " + zipcode);
            Log.d("a2", "radius : " + String.valueOf(radius));
        }

        try
        {
            zips = new ZipCodeTask().execute(
                    "https://www.zipcodeapi.com/rest/" +
                            apiKey +
                            "/radius.json/" +
                            zipcode +
                            "/" +
                            String.valueOf(1) +
                            "/mile")
                    .get(5000, TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException | java.util.concurrent.TimeoutException e)
        {
            Log.d("e", e.toString());
        }

        city = zips.get(0);
        Log.d("a2", "city in array list : " + city);

        try
        {
            zips = new ZipCodeTask().execute(
                    "https://www.zipcodeapi.com/rest/" +
                            apiKey +
                            "/radius.json/" +
                            zipcode +
                            "/" +
                            String.valueOf(radius) +
                            "/mile")
                    .get(5000, TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException | java.util.concurrent.TimeoutException e)
        {
            Log.d("e", e.toString());
        }

    }
}
