package com.example.cfeim.tangerine;

import android.graphics.Bitmap;
import android.os.Parcelable;

import java.io.Serializable;

public class CraigslistItem implements Serializable {

    private String Url;
    private String Title;
    private String Price;
    private String Desc;
    private String Thumbnail;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setThumbnail(String image){
        Thumbnail = image;
    }

    public String getThumbnail (){
        return Thumbnail;
    }

    public CraigslistItem(){
        Url = "";
        Title = "";
        Price = "";
        Desc = "";
    }

    public CraigslistItem(String TITLE, String URL, String PRICE, String DESC, String THUMB){
        Title = TITLE;
        Url = URL;
        Price = PRICE;
        Desc = DESC;
        Thumbnail = THUMB;
    }

}
