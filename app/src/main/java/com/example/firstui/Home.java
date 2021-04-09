package com.example.firstui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collection;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variabel dengan jenis data listview
    private ListView list;

    //memanggil class listview adapter
    private ListViewAdapter adapter;

    //deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listNama = new String[]{"Inayah", "Ilham", "Eris",
                "Fikri", "Maul", "Intan", "Vina", "Gita",
                "Vian", "Lutfi"};
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();
        for (int i = 0; i < listNama.length; i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }
        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                pm.setOnMenuItemClickListener(Home.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),Lihatdata.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}