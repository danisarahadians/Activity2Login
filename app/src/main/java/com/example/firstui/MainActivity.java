package com.example.firstui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklaration
    Button btnLog;

    EditText edemail, EdPwd;

    String nama, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel
        btnLog=findViewById(R.id.btnLog);

        edemail=findViewById(R.id.edEmail);

        EdPwd=findViewById(R.id.edPwd);

        //membuat  fungsi onclick
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menyimpan input user
                nama = edemail.getText().toString();

                password = EdPwd.getText().toString();

                //membuat variabel toast
                Toast t = Toast.makeText(getApplicationContext(),
                         "email anda:"+nama+" dan Password anda : "+password+"", Toast.LENGTH_LONG);

                String email = "danisa@gmail.com";
                String pass = "nlv123";

                if (nama.equals(email) && password.equals(pass))
                {
                    t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (!nama.equals(email) && password.equals(pass))
                {
                    t = Toast.makeText(getApplicationContext(),
                            "Email Salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else if (nama.equals(email) && !password.equals(pass))
                {
                    t = Toast.makeText(getApplicationContext(),
                            "Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }
                else
                {
                    t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Salah", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}