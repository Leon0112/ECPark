package com.example.ecpark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.email);
        e2 = (EditText)findViewById(R.id.pw);
        b1 = (Button)findViewById(R.id.submit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email, password);
                if (Chkemailpass == true)
                    Toast.makeText(getApplicationContext(), "Login, Successfully. Welcome!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Login fail, please try again.", Toast.LENGTH_SHORT).show();
            }
        });

}}
