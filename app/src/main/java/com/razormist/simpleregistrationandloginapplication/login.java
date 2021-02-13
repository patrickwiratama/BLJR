package com.razormist.simpleregistrationandloginapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bljr.DatabaseHelper;


public class Login extends AppCompatActivity {
    Button  btn_login;
    EditText et_userName, et_password;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);

        et_userName = (EditText)findViewById(R.id.et_userName);
        et_password = (EditText)findViewById(R.id.et_password);

        btn_login = (Button)findViewById(R.id.btn_login);
        //btn_lregister = (Button)findViewById(R.id.btn_lregister);

       // btn_lregister.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  Intent intent = new Intent(Login.this, MainActivity.class);
                //startActivity(intent);
           // }
        //});

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_userName.getText().toString();
                String password = et_password.getText().toString();

                Boolean checklogin = databaseHelper.CheckLogin(username, password);
                if(checklogin == true){
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid username or password, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}