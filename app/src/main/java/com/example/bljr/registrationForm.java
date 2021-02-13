package com.example.bljr;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class registrationForm extends AppCompatActivity {
    DatabaseHelper databaseHelper;

    EditText et_firstName, et_lastName, et_password, et_confirmPassword, et_email, et_University, et_Year, et_Major, et_Gender, et_DoB;
    Button btn_register, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        et_firstName = (EditText) findViewById(R.id.et_firstName);
        et_lastName = (EditText) findViewById(R.id.et_lastName);
        et_password = (EditText) findViewById(R.id.et_password);
        et_confirmPassword = (EditText) findViewById(R.id.et_confirmPassword);
        et_University = (EditText) findViewById(R.id.et_University);
        et_Major = (EditText) findViewById(R.id.et_Major);
        et_Year = (EditText) findViewById(R.id.et_Year);
        et_email = (EditText) findViewById(R.id.et_email);
        et_DoB = (EditText) findViewById(R.id.et_DoB);
        btn_register = (Button) findViewById(R.id.btn_register);
        //btn_login = (Button) findViewById(R.id.btn_login);

        //btn_login.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(MainActivity.this, Login.class);
               // startActivity(intent);
            //}
       // }
        //);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_firstName.getText().toString();
                String password = et_password.getText().toString();
                String confirm_password = et_confirmPassword.getText().toString();

                if (username.equals("") || password.equals("") || confirm_password.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Required", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.equals(confirm_password)) {
                        Boolean checkUserName = databaseHelper.CheckUserName(username, password);
                        if (checkUserName == true) {
                            Boolean insert = databaseHelper.Insert(username, password);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered", Toast.LENGTH_SHORT).show();
                                et_firstName.setText("");
                                et_password.setText("");
                                et_confirmPassword.setText("");
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Username already taken", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}