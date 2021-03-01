package com.example.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sekolah.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table siswa(nis integer null, nama text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO siswa (nis, nama) VALUES ('6874', 'Niko Febriyanto');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {

    }
}
