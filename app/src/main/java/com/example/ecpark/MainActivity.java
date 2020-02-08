package com.example.ecpark;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3,e4;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        e1= (EditText)findViewById(R.id.name);
        e2= (EditText)findViewById(R.id.pw);
        e3= (EditText)findViewById(R.id.email);
        e4= (EditText)findViewById(R.id.vrm);
        b1= (Button)findViewById(R.id.submit);
        b2= (Button)findViewById(R.id.login);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                String s4 = e4.getText().toString();


                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("")){
                     Toast.makeText(getApplicationContext(), "Field is empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean chkevrm = db.chkevrm(s3);
                    if (chkevrm == true){
                        boolean insert = db.insert(s1, s2, s3, s4);
                        if(insert == true){
                            Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(getApplicationContext(),"VRM has Already used",Toast.LENGTH_SHORT).show();
                        }
                    }

                }
            }
                              }


        );
    }


        

}
