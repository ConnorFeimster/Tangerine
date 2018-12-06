package com.example.cfeim.tangerine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] itemprice;
    private final String[] img;

    public CustomListAdapter(Activity context, String[] itemname, String[] itemprice, String[] image) {
        super(context, R.layout.listview_with_images, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.img = image;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_with_images, null,true);

        Picasso.Builder builder = new Picasso.Builder(context);

        TextView txtTitle = rowView.findViewById(R.id.item);
        ImageView imageView = rowView.findViewById(R.id.icon);
        TextView extratxt = rowView.findViewById(R.id.textView1);

        builder.build().load(img[position]).into(imageView);
        txtTitle.setText(itemname[position]);
        extratxt.setText(itemprice[position]);

        return rowView;
    }
}
