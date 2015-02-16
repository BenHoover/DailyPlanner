package com.example.benjaminhoover.dailyplanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by benjamin.hoover on 2/15/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DailyPlanner = "dailyplanner";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ITEM = "item";
    public static final String COLUMN_QUANTITY = "quantity";
    private static final String DATABASE_NAME = "dailyplanner.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + DailyPlanner + "(" + COLUMN_ID + " integer primary key autoincrement," + COLUMN_ITEM + " text not null,"
            + COLUMN_QUANTITY + " int not null);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + DailyPlanner);
        onCreate(db);
    }

}
