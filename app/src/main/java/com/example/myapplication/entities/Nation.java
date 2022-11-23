package com.example.myapplication.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Nation {

    @PrimaryKey(autoGenerate = true)
    private int nation_id;

    private String name;

    public Nation(String name) {
        this.name = name;
    }

    public int getNation_id() {
        return nation_id;
    }

    public void setNation_id(int id) {
        this.nation_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nationality{" + "id: " + nation_id + ", country: " + name + '}';
    }
}
