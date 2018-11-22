package com.example.cfeim.tangerine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView edit_item;
    public static TextView edit_zipcode;
    public static TextView edit_radius;
    public static Button button_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_item = findViewById(R.id.edit_Item);
        edit_zipcode = findViewById(R.id.edit_zipcode);
        edit_radius = findViewById(R.id.edit_radius);
        button_go = findViewById(R.id.button_go);

    }
}
