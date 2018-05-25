package com.example.darshana.notesafeapp;

import android.content.Context;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Note implements Serializable {
    private long mDateTime;
    private String mTitle;
    private String mContent;

    public Note(long mDateTime, String mTitle, String mContent) {
        this.mDateTime = mDateTime;
        this.mTitle = mTitle;
        this.mContent = mContent;
    }

    public long getmDateTime() {
        return mDateTime;
    }

    public void setmDateTime(long mDateTime) {
        this.mDateTime = mDateTime;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }


    //get date and time
    public String getDateTimeFormatted(Context context){
        SimpleDateFormat adf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss",context.getResources().getConfiguration().locale);
        adf.setTimeZone(TimeZone.getDefault());
        return adf.format(new Date(mDateTime));
    }
}
