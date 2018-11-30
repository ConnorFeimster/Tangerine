package com.example.cfeim.tangerine;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView edit_item;
    public Spinner spinner_City;
    public Button button_go;

    private static String string_item = "";
    private static String string_City = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_item = findViewById(R.id.edit_Item);
        spinner_City = findViewById(R.id.spinner_City);
        button_go = findViewById(R.id.button_go);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button", "go button was pressed");
                string_item = edit_item.getText().toString();
                string_City = spinner_City.getSelectedItem().toString();

                if(TextUtils.isEmpty(string_item)){
                    Toast.makeText(MainActivity.this, "You must enter an item to search.", Toast.LENGTH_SHORT).show();
                }
                else if (!isConnected())
                {
                    Toast.makeText(MainActivity.this, "Not connected to the internet", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.d("a1", "string_search : " + string_item);
                    Log.d("a1", "string_City : " + String.valueOf(string_City));
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("item_search", string_item);
                    i.putExtra("item_city", string_City);
                    startActivity(i);
                }
            }
        });
    }

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                        && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            return false;
        }
        return true;
    }
}
