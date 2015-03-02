package com.example.benjaminhoover.dailyplanner;

/**
 * Created by benjamin.hoover on 2/15/2015.
 */
public class DailyPlannerListItem {
    private long id;
    private String item;
    private String date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return item + " - " + String.valueOf(date);
    }
}
