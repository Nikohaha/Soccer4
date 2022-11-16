package com.codingstuff.soccerlive;

public class Soccer {

    private String title , side1 , date, thumbnail;
//123
    public Soccer(String title, String side1, String date, String thumbnail ){
        this.title = title;
        this.side1 = side1;
        this.date = date;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getSide1() {
        return side1;
    }

    public String getDate() {
        return date;
    }

    public String getThumbnail( ) {return thumbnail;}


}
