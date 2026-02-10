package com.example.bazy_danyuch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MaszynyBazyDanych maszynyDB;
    List<Tokarka> tokarkiList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        maszynyDB = MaszynyBazyDanych.zwrocBazeDanych(MainActivity.this);
        maszynyDB.zwrocTokarkaDAO().wstawTokarke(new Tokarka("Nova", "Nebula", 35, 1500));
        maszynyDB.zwrocTokarkaDAO().wstawTokarke(new Tokarka("DRSelemeister", "Stratos XL", 55, 2000));
        ListView listView = findViewById(R.id.listaTokarek);
        tokarkiList = maszynyDB.zwrocTokarkaDAO().zwrocWszystkieTokarki();
        ArrayAdapter<Tokarka> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, tokarkiList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tokarkiList.remove(i);
                maszynyDB.zwrocTokarkaDAO().usunTokarke(tokarkiList.get(i));
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}