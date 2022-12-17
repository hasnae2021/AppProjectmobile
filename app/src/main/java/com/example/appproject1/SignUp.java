package com.example.appproject1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText username,password,repasssword;
    Button signup,signin;

    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        repasssword=findViewById(R.id.repassword);
        DB=new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= username.getText().toString();
                String pass= password.getText().toString();
                String repass= repasssword.getText().toString();

                if(TextUtils.isEmpty(user)|| TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass))
                    Toast.makeText(SignUp.this,"All fields Requierd",Toast.LENGTH_SHORT).show();
                else{

                    if(pass.equals(repass)){
                        Boolean checkuser=DB.checkusername(user);
                        if (checkuser==false) {
                            Boolean insert = DB.insertData(user, pass);
                            if (insert == true) {
                                Toast.makeText(SignUp.this, "registered Succefully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUp.this, "User already Exists", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(SignUp.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),SignIn.class);
                startActivity(intent);
            }
        });
    }
}