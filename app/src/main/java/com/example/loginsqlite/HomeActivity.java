package com.example.loginsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    EditText name,email,age;
    Button insert,view;
    DBHelper1 DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name=(EditText) findViewById(R.id.name);
        email=(EditText) findViewById(R.id.email);
        age= (EditText) findViewById(R.id.age);
        insert=(Button) findViewById(R.id.btnInsert);
        view=(Button) findViewById(R.id.btnView);
        DB= new DBHelper1(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,Userlist.class));
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String emailTXT= email.getText().toString();
                String ageTXT= age.getText().toString();
                Boolean checkinsertdata=DB.insertData(nameTXT,emailTXT,ageTXT);
                if (checkinsertdata==true){
                    Toast.makeText(HomeActivity.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(HomeActivity.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}