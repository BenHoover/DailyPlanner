package com.example.benjaminhoover.dailyplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by benjamin.hoover on 2/15/2015.
 */
public class DailyPlannerListDataSource {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private String[] allColums = {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_ITEM, DatabaseHelper.COLUMN_QUANTITY};

    public DailyPlannerListDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public DailyPlannerListItem createDailyPlannerItem(String item, int quantity){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ITEM, item);
        values.put(DatabaseHelper.COLUMN_QUANTITY, quantity);

        //Change Below
        return null;
    }

}
