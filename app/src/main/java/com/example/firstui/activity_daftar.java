package com.example.firstui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class activity_daftar extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.editRepass);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {

                    Snackbar.make(v,"Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else {

                    if (edtPassword.getText().toString().equals(edtPassword.getText().toString()))
                    {

                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {

                        Snackbar.make(v, "Password dan Repassword harus sama!!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}