package com.example.bazy_danyuch;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface TokarkaDAO {
    @Insert
    void wstawTokarke(Tokarka tokarka);
    @Delete
    void usunTokarke(Tokarka tokarka);
    @Update
    void zmienParametryTokarki(Tokarka tokarka);

    @Query("Select * from tokareczki")
    List<Tokarka> zwrocWszystkieTokarki();

    @Query("Select model from tokareczki where moc_silnika > :moc")
    List<String> zwrocModeleOMocy(int moc);


}
