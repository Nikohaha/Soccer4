package com.codingstuff.soccerlive.Helpers;

public class Soccer {

    private String title , date , side1, key_id,favStatus;


    public Soccer(String title, String date){
        this.title = title;
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getSide1() {
        return side1;
    }

    public String getKey_id() {
        return key_id;
    }

    public String getFavStatus() {
        return favStatus;
    }
}
