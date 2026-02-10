package com.example.bazy_danyuch;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tokareczki")

public class Tokarka {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String marka;
    private String model;
    @ColumnInfo(name = "srednica_toczenia")
    private int srednica;
    @ColumnInfo(name = "moc_silnika")
    private int mocSilnika;

    public Tokarka(String marka, String model, int srednica, int mocSilnika) {
        this.id = 0;
        this.marka = marka;
        this.model = model;
        this.srednica = srednica;
        this.mocSilnika = mocSilnika;
    }

    public int getId() {
        return id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSrednica() {
        return srednica;
    }

    public void setSrednica(int srednica) {
        this.srednica = srednica;
    }

    public int getMocSilnika() {
        return mocSilnika;
    }

    public void setMocSilnika(int mocSilnika) {
        this.mocSilnika = mocSilnika;
    }

    @Override
    public String toString() {
        return "Tokarka{" +
                "id=" + id +
                ", marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", srednica=" + srednica +
                ", mocSilnika=" + mocSilnika +
                '}';
    }
}
