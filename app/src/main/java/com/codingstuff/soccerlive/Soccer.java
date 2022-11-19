package com.codingstuff.soccerlive;

public class Soccer {

    private String title , date , side1, thumbnail;
//123
    public Soccer(String title,  String date,String side1, String thumbnail ){
        this.title = title;
        this.date = date;
        this.side1 = side1;
        this.thumbnail = thumbnail;
    }

    public Soccer(String title, String date){
        this.title = title;
        this.date = date;
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


    public String getThumbnail( ) {return thumbnail;}




}
