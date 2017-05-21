package com.example.karthik.karthiks_app;

/**
 * Created by karthik on 5/20/2017.
 */

public class DataModel {

    private String title = null;
    private String time = null;
    private String description = null;
    private int imgdata = 0;


    public DataModel(String title,String description,String time,int image){
        this.title=title;
        this.time=time;
        this.description=description;
        this.imgdata=image;
    }




    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImgdata() {
        return imgdata;
    }

    public void setImgdata(int imgdata) {
        this.imgdata = imgdata;
    }



}
