package com.learnque.my.notesapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.learnque.my.notesapp.db.DatabaseContract.NoteColumns.DATE;
import static com.learnque.my.notesapp.db.DatabaseContract.NoteColumns.DESC;
import static com.learnque.my.notesapp.db.DatabaseContract.NoteColumns.TABLE_NOTE;
import static com.learnque.my.notesapp.db.DatabaseContract.NoteColumns.TITLE;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "dbnotes";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_NOTE = "CREATE TABLE " + TABLE_NOTE + "(" +
            _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TITLE + " TEXT NOT NULL," +
            DESC + " TEXT NOT NULL," +
            DATE + " TEXT NOT NULL)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_NOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(db);
    }
}
