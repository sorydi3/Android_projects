package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {
    //declare the database name as final static variable
    private static final String DATA_BASE_NAME="waitlist.db";
    //DATA BASE VERSION should be updated anytime we modify the database to force
    //the users to upgrade to the new version
    private static final int DATA_BASE_VERSION=1;
    public WaitlistDbHelper(Context context){
        super(context,DATA_BASE_NAME,null,DATA_BASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WAITLIST_TABLE="CREATE TABLE " +
                WaitlistContract.WaitlistEntry.TABLE_NAME +"( " + WaitlistContract.WaitlistEntry._ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME + " TEXT NOT NULL, "
                + WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE+ " INTEGER NOT NULL, "+
                WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP +" TIMESTAMP DEFAULT CURRENT_TIMESTAMP "+ ");";
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
     sqLiteDatabase.execSQL("DROP TABLE IF EXIST "+ WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"

    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor

    // TODO (5) Override the onCreate method

        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE

    // TODO (8) Override the onUpgrade method

        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it

}