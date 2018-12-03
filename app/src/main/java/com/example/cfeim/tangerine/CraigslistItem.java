package com.example.cfeim.tangerine;

import android.graphics.Bitmap;

public class CraigslistItem {

    private String Url;
    private String Title;
    private int Price;
    private String Desc;
    private boolean Hide;
    private Bitmap thumbnail;

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

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
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

    public void setThumbnail(Bitmap image){
        thumbnail = image;
    }

    public Bitmap getThumbnail (){
        return thumbnail;
    }

    public CraigslistItem(){
        Url = "";
        Title = "";
        Price = 0;
        Desc = "";
        Hide = false;
    }

    public CraigslistItem(String TITLE, String URL, int PRICE, String DESC, boolean HIDE){
        Title = TITLE;
        Url = URL;
        Price = PRICE;
        Desc = DESC;
        Hide = HIDE;
    }

}
