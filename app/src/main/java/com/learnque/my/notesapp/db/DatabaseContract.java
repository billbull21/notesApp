package com.learnque.my.notesapp.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static final class NoteColumns implements BaseColumns {
        public static String TABLE_NOTE = "note";
        public static String TITLE = "title";
        public static String DESC = "desc";
        public static String DATE = "date";
    }

}
