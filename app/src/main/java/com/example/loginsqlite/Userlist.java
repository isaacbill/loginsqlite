package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> name,email,age;
    DBHelper1 DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
        DB=new DBHelper1(this);
        name=new ArrayList<>();
        email=new ArrayList<>();
        age=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,name,email,age);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();





    }

    private void displayData() {
        Cursor cursor= DB.getData();
        if (cursor.getCount()==0){
            Toast.makeText(Userlist.this, "No entry exists", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                age.add(cursor.getString(2));

            }
        }
    }
}