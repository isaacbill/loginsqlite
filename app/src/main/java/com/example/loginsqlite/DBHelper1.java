package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper {

    public DBHelper1(Context context) {
        super(context, "userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(name TEXT primary key, email TEXT, age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists userdetails");
    }
    public Boolean insertData(String name, String email,String age){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email",email);
        contentValues.put("age",age);
        long result= DB.insert("userdetails",null,contentValues);
        if (result==-1) {
            return false;
        }
        else{
            return true;
        }

    }
    public Cursor  getData(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("select * from userdetails",null);
        return cursor;
    }

}
