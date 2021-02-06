package com.example.bljr;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "registrationForm.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "firstName";
    public static final String COL_2 = "lastName ";
    public static final String COL_3 = "email";
    public static final String COL_4 = "Tempat/Tanggal Lahir";
    public static final String COL_5 = "University";
    public static final String COL_6 = "Year";
    public static final String COL_7 = "Major";
    public static final String COL_8 = "Gender";
    public static final String COL_9 = "Password";
    public static final String COL_10 = " ConfirmPassword";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTO INCREMENT, firstName TEXT, lastName, TEXT, email TEXT, Tempat/Tanggal lahir TEXT, University TEXT, Year TEXT, Major TEXT, Gender TEXT, Password TEXT, ConfirmPassword TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("FROP TABLE IF EXISTS" + TABLE_NAME); //Drop older table if exists
        onCreate(db);
    }

    public
}
