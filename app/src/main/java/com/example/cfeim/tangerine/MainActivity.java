package com.example.cfeim.tangerine;

import android.content.Intent;
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
    public TextView edit_zipcode;
    public Spinner spinner_radius;
    public Button button_go;

    private static String string_item = "";
    private static String string_zipcode = "";
    private static Integer int_radius = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_item = findViewById(R.id.edit_Item);
        edit_zipcode = findViewById(R.id.edit_zipcode);
        spinner_radius = findViewById(R.id.spinner_radius);
        button_go = findViewById(R.id.button_go);

        String[] strArr = getResources().getStringArray(R.array.radius);
        Integer[] intArr = new Integer[strArr.length];
        for (int i = 0; i < intArr.length; i++){
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, intArr);
        spinner_radius.setAdapter(adapter);

        button_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button", "go button was pressed");
                string_item = edit_item.getText().toString();
                string_zipcode = edit_zipcode.getText().toString();
                int_radius = (Integer)spinner_radius.getSelectedItem();

                if(TextUtils.isEmpty(string_item)){
                    Toast.makeText(MainActivity.this, "You must enter an item to search.", Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(string_zipcode))
                {
                    Toast.makeText(MainActivity.this, "You must enter a zipcode.", Toast.LENGTH_SHORT).show();
                }
                else if (string_zipcode.length() > 5)
                {
                    Toast.makeText(MainActivity.this, "The zipcode you entered is too long.", Toast.LENGTH_SHORT).show();
                }
                else if (string_zipcode.length() < 5)
                {
                    Toast.makeText(MainActivity.this, "The zipcode you entered is too short.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Log.d("a1", "string_search : " + string_item);
                    Log.d("a1", "string_zipcode : " + string_zipcode);
                    Log.d("a1", "int_radius : " + String.valueOf(int_radius));
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    i.putExtra("item_search", string_item);
                    i.putExtra("item_zipcode", string_zipcode);
                    i.putExtra("item_radius", int_radius);
                    startActivity(i);
                }
            }
        });
    }
}
