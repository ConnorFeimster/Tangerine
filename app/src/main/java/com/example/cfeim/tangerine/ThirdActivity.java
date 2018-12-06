package com.example.cfeim.tangerine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ThirdActivity extends AppCompatActivity {

    private CraigslistItem clItem;

    private TextView textView_title;
    private TextView textView_price;
    private ImageView imageView_image;
    private TextView textView_desc;

    private String itemTitle;
    private String itemPrice;
    private String itemDesc;
    private String itemThumb;
    private String itemUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView_title = findViewById(R.id.textView_itemTitle);
        textView_price = findViewById(R.id.textView_itemPrice);
        imageView_image = findViewById(R.id.imageView_itemImage);
        textView_desc = findViewById(R.id.textView_itemDesc);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            clItem = (CraigslistItem) extras.getSerializable("cl_item");

            itemTitle = clItem.getTitle();
            itemPrice = clItem.getPrice();
            itemThumb = clItem.getThumbnail();
            itemUrl = clItem.getUrl();
            itemDesc = clItem.getDesc();

            Log.d("a3", "title : " + itemTitle);
            Log.d("a3", "price : " + itemPrice);
            Log.d("a3", "desc : " + itemDesc);
            Log.d("a3", "thumb : " + itemThumb);
            Log.d("a3", "url : " + itemUrl);

        }

        textView_title.setClickable(true);
        textView_title.setMovementMethod(LinkMovementMethod.getInstance());
        String link = "<a href = \'" + itemUrl + "\'>" + itemTitle + "</a>";
        Log.d("a3", "link : " + link);
        textView_title.setText(Html.fromHtml(link));

        textView_price.setText("$" + itemPrice);
        Picasso.with(this).load(itemThumb).into(imageView_image);
        textView_desc.setText(itemDesc);
    }
}
