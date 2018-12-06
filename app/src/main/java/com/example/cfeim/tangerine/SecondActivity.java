package com.example.cfeim.tangerine;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SecondActivity extends AppCompatActivity {

    private static String urlPrefix = "https://";
    private static String craigslistURL = ".craigslist.org/search/sss?format=rss&query=";
    private static String titleOnly = "&srchType=T";

    private String item;
    private String city;
    private boolean checked;
    private int avgPrice;

    private String[] arrayName;
    private String[] arrayPrice;
    private String[] arrayImg;
    
    private TextView itemName;
    private TextView averagePrice;
    private TextView numItems;
    private ListView list;
    private CraigslistItem clItem;

    public  ArrayList<CraigslistItem> craigslistItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        craigslistItems = new ArrayList<>();
        avgPrice = 0;
        int temp = 0;
        int numPrice = 0;
        
        itemName = findViewById(R.id.textView_Item);
        list = findViewById(R.id.listView_S2);
        averagePrice = findViewById(R.id.textView_avgPrice);
        numItems = findViewById(R.id.textView_numItem);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            item = extras.getString("item_search");
            city = extras.getString("item_city");
            checked = extras.getBoolean("box_checked");
            
            itemName.setText("\"" + item + "\"");

            Log.d("a2", "item : " + item);
            Log.d("a2", "city : " + city);
            Log.d("a2", "check : " + checked);
        }

        if (city.contains(" "))
        {
            city = city.replace(" ", "");
            Log.d("a2", "city remove space : " + city);
        }

        if (item.contains(" "))
        {
            item = item.replace(" ", "");
        }

        try
        {
            String url = urlPrefix + city + craigslistURL + item;
            if (checked)
            {
                url = url + titleOnly;
            }
            Log.d("a2", "URL : " + url);
            craigslistItems = new CraigsListTask().execute(url, item).get(5000, TimeUnit.MILLISECONDS);

            if (craigslistItems.size() == 0)
            {
                Toast.makeText(SecondActivity.this, "There were no results. Go back and enter another search term.", Toast.LENGTH_LONG).show();
            }
            else
            {
                arrayName = new String[craigslistItems.size()];
                arrayPrice = new String[craigslistItems.size()];
                arrayImg = new String[craigslistItems.size()];

                for (int i = 0; i < craigslistItems.size(); i++)
                {
                    clItem = craigslistItems.get(i);
                    arrayName[i] = clItem.getTitle();
                    arrayPrice[i] = "$" + clItem.getPrice();
                    arrayImg[i] = clItem.getThumbnail();
                    if(Integer.parseInt(clItem.getPrice()) > 1)
                    {
                        numPrice++;
                        temp += Integer.parseInt(clItem.getPrice());
                    }
                }
                avgPrice = temp / numPrice;
            }

        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException | java.util.concurrent.TimeoutException e)
        {
            Log.d("e", "A2 error making call to CL : " + e.toString());
        }
        
        Log.d("a2", "craigslistItems length : " + craigslistItems.size());

        if (craigslistItems.size() > 0)
        {
            averagePrice.setText("$" + String.valueOf(avgPrice));
            numItems.setText(String.valueOf(craigslistItems.size()));

            CustomListAdapter adapter = new CustomListAdapter(this, arrayName, arrayPrice, arrayImg);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                    i.putExtra("cl_item", craigslistItems.get(position));
                    startActivity(i);
                    Log.d("aa", "pos : " + position);
                }
            });
        }
        else
        {
            averagePrice.setText("0");
            numItems.setText("0");
            Toast.makeText(SecondActivity.this, "There were no results. Go back and enter another search term.", Toast.LENGTH_LONG).show();
        }
    }
}
