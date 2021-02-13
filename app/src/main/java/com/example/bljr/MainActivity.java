package com.example.bljr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Year;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg;
    EditText _txtfanme, _txtfirstName, _txtlastName, _txtlemail, _txtTempatTanggalLahir, _txtUniversity, _txtYear, _txtMajor, _txtGender, _txtPassword, _txtConfirmPassword;
    private Object String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openHelper=new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        _btnreg = (Button)findViewById(R.id.btnreg);
        // _txtfanme=(EditText)findViewById(R.id.textfname);
        _txtfirstName=(EditText)findViewById(R.id.textfirstName);
        _txtlastName=(EditText)findViewById(R.id.textlastName);
        _txtlemail=(EditText)findViewById(R.id.textlemail);
        _txtTempatTanggalLahir=(EditText)findViewById(R.id.textTempatTanggalLahir);
        _txtUniversity=(EditText)findViewById(R.id.textUniversity);
        _txtYear=(EditText)findViewById(R.id.textYear);
        _txtMajor=(EditText)findViewById(R.id.textMajor);
        _txtGender=(EditText)findViewById(R.id.textGender);
        _txtPassword=(EditText)findViewById(R.id.textPassword);
        _txtConfirmPassword=(EditText)findViewById(R.id.textConfirmPassword);
        _btnreg.setOnClickListener(new View.onClockListener() {
            @Override
            public void onClock(View v) {
                db = openHelper.getWritableDatabase();
                //String fname = _txtfanme.getText().toString();
                String firstName = _txtfirstName.getText().toString();
                String lastName = _txtlastName.getText().toString();
                String lemail = _txtlemail.getText().toString();
                String TempatTanggalLahir = _txtTempatTanggalLahir.getText().toString();
                String University = _txtUniversity.getText().toString();
                String Year = _txtYear.getText().toString();
                String Major = _txtMajor.getText().toString();
                String Gender = _txtGender.getText().toString();
                String Password = _txtPassword.getText().toString();
                String ConfirmPassword = _txtConfirmPassword.getText().toString();
                insertdata(firstName, lastName, lemail, TempatTanggalLahir, University, Year, Major, Gender, Password, ConfirmPassword);
                Toast.makeText(getApplicationContext(), "register succesfully", Toast.LENGTH_LONG.show());
            }
        });

        public void insertdata (String firstName, String lastName, String lemail, String TempatTanggalLahir, String University, String Year, String Major, String Gender, String Password, String ConfirmPassword )
        ContentValues contentValues = new ContentValues();
        //ContentValues.put(DatabaseHelper.COL_2,fname);
        ContentValues.put(DatabaseHelper.COL_2,firstName);
        ContentValues.put(DatabaseHelper.COL_3, lastname);
        ContentValues.put(DatabaseHelper.COL_4,TempatTanggalLahir);
        ContentValues.put(DatabaseHelper.COL_5,University);
        ContentValues.put(DatabaseHelper.COL_6, Year);
        ContentValues.put(DatabaseHelper.COL_7,Major);
        ContentValues.put(DatabaseHelper.COL_8,Gender);
        ContentValues.put(DatabaseHelper.COL_9,Password);
        ContentValues.put(DatabaseHelper.COL_10,ConfirmPassword);
        long id = db.insert(DatabaseHelper.TABLE_NAME null, contentValues);
        

    }
}