package com.example.cfeim.tangerine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static TextView edit_item;
    public static TextView edit_zipcode;
    public static Spinner spinner_radius;
    public static Button button_go;

    private static String string_item = "";
    private static String string_zipcode = "";
    private static String string_radius = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_item = findViewById(R.id.edit_Item);
        edit_zipcode = findViewById(R.id.edit_zipcode);
        spinner_radius = findViewById(R.id.spinner_radius);
        button_go = findViewById(R.id.button_go);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                string_item = edit_item.getText().toString();
                string_zipcode = edit_zipcode.getText().toString();
                string_radius = spinner_radius.getSelectedItem().toString();

                if(TextUtils.isEmpty(string_item)){
                    Toast.makeText(MainActivity.this, "You must enter an item to search.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(string_zipcode))
                {
                    Toast.makeText(MainActivity.this, "You must enter a zipcode.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                }
            }
        });
    }
}
