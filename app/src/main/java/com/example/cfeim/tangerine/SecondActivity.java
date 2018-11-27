package com.example.cfeim.tangerine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    private String item;
    private String zipcode;
    private int radius;

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

    }
}
