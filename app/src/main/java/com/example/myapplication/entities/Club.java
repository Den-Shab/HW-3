package com.example.myapplication.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Club {

    @PrimaryKey(autoGenerate = true)
    private int club_id;

    private String name;

    private String location;

    public int getClub_id() {
        return club_id;
    }

    public void setClub_id(int id) {
        this.club_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Club(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Club{" + "id: " + club_id + ", name: " + name + ", location: " + location + '}';
    }
}
