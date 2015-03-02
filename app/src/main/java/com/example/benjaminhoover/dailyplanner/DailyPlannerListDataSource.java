package com.example.benjaminhoover.dailyplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin.hoover on 2/15/2015.
 */
public class DailyPlannerListDataSource {
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;
    private String[] allColumns = {DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_ITEM, DatabaseHelper.COLUMN_DATE};

    public DailyPlannerListDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public DailyPlannerListItem createDailyPlannerItem(String item, String quantity) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ITEM, item);
        values.put(DatabaseHelper.COLUMN_DATE, quantity);
        long insertId = db.insert(dbHelper.DailyPlanner, null,
                values);
        Cursor cursor = db.query(dbHelper.DailyPlanner,
                allColumns, dbHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        DailyPlannerListItem newShoppingListItem = cursorToDailyPlannerListItem(cursor);
        cursor.close();
        return newShoppingListItem;
    }

    public List<DailyPlannerListItem> getAllItems() {
        List<DailyPlannerListItem> list = new ArrayList<DailyPlannerListItem>();
        Cursor cursor = db.query(dbHelper.DailyPlanner,allColumns,null,null,null,null,null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            DailyPlannerListItem item = cursorToDailyPlannerListItem(cursor);
            list.add(item);
            cursor.moveToNext();
        }

        cursor.close();
        return list;
    }

    private DailyPlannerListItem cursorToDailyPlannerListItem(Cursor cursor) {
        DailyPlannerListItem listItem = new DailyPlannerListItem();
        listItem.setId(cursor.getLong(0));
        listItem.setItem(cursor.getString(1));
        listItem.setDate(cursor.getString(2));
        return listItem;
    }

    public boolean deleteItem(DailyPlannerListItem item) {
        int success = db.delete(dbHelper.DailyPlanner,dbHelper.COLUMN_ID + " = " + item.getId(),null);
        return success > 0;
    }
}
