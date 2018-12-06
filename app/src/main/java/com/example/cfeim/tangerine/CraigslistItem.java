package com.example.cfeim.tangerine;

import android.graphics.Bitmap;

public class CraigslistItem {

    private String Url;
    private String Title;
    private String Price;
    private String Desc;
    private boolean Hide;
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

    public void setHide(boolean hide){
        Hide = hide;
    }

    public boolean getHide(){
        return Hide;
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
        Hide = false;
    }

    public CraigslistItem(String TITLE, String URL, String PRICE, String DESC, String THUMB, boolean HIDE){
        Title = TITLE;
        Url = URL;
        Price = PRICE;
        Desc = DESC;
        Thumbnail = THUMB;
        Hide = HIDE;
    }

}
