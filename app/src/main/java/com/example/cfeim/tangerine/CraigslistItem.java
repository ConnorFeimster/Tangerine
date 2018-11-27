package com.example.cfeim.tangerine;

public class CraigslistItem {

    private String Url;
    private String Title;
    private String City;
    private int Price;
    private String Desc;
    private boolean Hide;

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

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
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

    public CraigslistItem(){
        Url = "";
        Title = "";
        City = "";
        Price = 0;
        Desc = "";
        Hide = false;
    }

}
