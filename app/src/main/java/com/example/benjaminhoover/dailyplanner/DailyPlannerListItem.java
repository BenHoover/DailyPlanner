package com.example.benjaminhoover.dailyplanner;

/**
 * Created by benjamin.hoover on 2/15/2015.
 */
public class DailyPlannerListItem {
    private long id;
    private String item;
    private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return item + " - " + String.valueOf(quantity);
    }
}
