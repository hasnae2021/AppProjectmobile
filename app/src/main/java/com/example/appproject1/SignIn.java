package com.example.appproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText username, password;
    Button signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        signin = findViewById(R.id.signin);
        DB = new DBHelper(this);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
                    Toast.makeText(SignIn.this, "All fields Required", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusrnamepassword(user, pass);
                    if (checkuserpass == true) {
                        Toast.makeText(SignIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}