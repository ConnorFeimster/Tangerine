package com.example.cfeim.tangerine;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {

    private static String urlPrefix = "https://";
    private static String craigslistURL = ".craigslist.org/search/sss?format=rss&query=";

    private String item;
    private String city;
    
    private TextView itemName;

    public  ArrayList<CraigslistItem> craigslistItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        craigslistItems = new ArrayList<>();
        
        itemName = findViewById(R.id.textView_Item);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            item = extras.getString("item_search");
            city = extras.getString("item_city");
            
            itemName.setText("\"" + item + "\"");

            Log.d("a2", "item : " + item);
            Log.d("a2", "city : " + city);
        }

        if (city.contains(" "))
        {
            city = city.replace(" ", "");
            Log.d("a2", "city remove space : " + city);
        }

        try
        {
            String url = urlPrefix + city + craigslistURL + item;
            Log.d("a2", "URL : " + url);
            craigslistItems = new CraigsListTask().execute(url, item).get(5000, TimeUnit.MILLISECONDS);
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException | java.util.concurrent.TimeoutException e)
        {
            Log.d("e", "A2 error making call to CL : " + e.toString());
        }

        Log.d("a2", "craigslistItems : " + craigslistItems.toString());
        Log.d("a2", "craigslistItems length : " + craigslistItems.size());

    }
}
