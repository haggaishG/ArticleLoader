package com.exercise.articlesloader.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MetaData {
    //        {
    //            "creationTime": "2017-03-14T06:44:19.000Z",
    //                "updateTime": "2017-06-19T14:29:25.000Z"
    //        }
    private String creationTime ;
    private String updateTime;

    public MetaData(String creationTime, String updateTime) {
        this.creationTime = creationTime;
        this.updateTime = updateTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }


    public static String formatDate(String date) {
        //"2017-03-14T06:44:19.000Z",
        SimpleDateFormat spf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        Date newDate= null;
        try {
            newDate = spf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf= new SimpleDateFormat("dd MMM, yyyy");
        date = spf.format(newDate);
        return date ;
    }
}