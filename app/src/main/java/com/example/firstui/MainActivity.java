package com.example.firstui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //membuat kondisi jika yang dipilih adala id mDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), activity_daftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

                //mengeset email yang benar
                String email = "danisa@gmail.com";
                //mengeset password yang benar
                String pass = "nlv123";

                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()){
                    //membuat variabel toast dan menampilkan pesan "Edit text tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password wajib diisi!!!",
                            Toast.LENGTH_LONG);
                    //menampilkan Toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();
                } else {

                    //Mengecek apakah isi dari email dan password sudah sama dengan email dan
                    // password yang sudah diset
                    if (nama.equals(email) && password.equals(pass))
                    {
                        //Membuat variabel toast dan menampilkan pesan "Login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                        //Mmebuat object Bundle
                        Bundle b = new Bundle();
                        //memasukkan value dari variabel nama dengan kunci "a"
                        // dan dimasukkan ke dalam bundle
                        b.putString("a", nama.trim());
                        //memasukkan value dari variabel nama dengan kunci "b"
                        // dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());
                        //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        //memasukkan bundle ke dalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);

                    } else{
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}