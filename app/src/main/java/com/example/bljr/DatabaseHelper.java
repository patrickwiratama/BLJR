package com.example.bljr;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "login.db";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null, 1);
    }

    public void onCreate (SQLiteDatabase db){
        db.execSQL("Create Table user (ID Integer Primary Key AutoIncrement, userName Text, password Text)");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if Exists user");
    }

    public boolean Insert (String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("firstName", userName);
        contentValues.put("lastName", password);
        long result = sqLiteDatabase.insert("user", null, contentValues);
        if (result == -1){
            return false;}
            else{
                return true;
            }
        }
        public Boolean CheckUserName(String userName, String password){
            SQLiteDatabase sqLiteDatabase1 = this.getWritableDatabase();
            Cursor cursor = sqLiteDatabase1.rawQuery("SELECT * FROM user Where Username=?", new String[]{userName,password});
            if (cursor.getCount()>0){
                return false;}
                else{
                    return true;
                }
            }

    public Boolean Checkpassword(String userName, String password){
        SQLiteDatabase sqLiteDatabase1 = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase1.rawQuery("SELECT * FROM user Where Username=? AND password=?", new String[]{userName,password});
        if (cursor.getCount()>0){
            return true;}
        else{
            return false;
        }
    }

    public Boolean CheckLogin(String userName, String password) {
        SQLiteDatabase sqLiteDatabase1 = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase1.rawQuery("SELECT * FROM user Where Username=? AND password=?", new String[]{userName,password});
        if (cursor.getCount()>0){
            return true;}
        else{
            return false;
        }
    }
}
