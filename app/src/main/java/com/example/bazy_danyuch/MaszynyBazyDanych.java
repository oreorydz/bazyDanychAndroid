package com.example.bazy_danyuch;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Tokarka.class}, version = 1)
public abstract class MaszynyBazyDanych extends RoomDatabase {
    public abstract TokarkaDAO zwrocTokarkaDAO();
    private static MaszynyBazyDanych instancja;
    public static MaszynyBazyDanych zwrocBazeDanych(Context context){
        if (instancja==null){
            instancja = Room.databaseBuilder(
                    context.getApplicationContext(),
                    MaszynyBazyDanych.class,
                    "maszyny.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instancja;
    }
}
