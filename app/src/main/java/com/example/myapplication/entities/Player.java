package com.example.myapplication.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity//(foreignKeys = {@ForeignKey(entity = Nation.class,
//        parentColumns = "nation_id",
//        childColumns = "nation",
//        onDelete = ForeignKey.CASCADE)
//})
public class Player {

    @PrimaryKey(autoGenerate = true)
    private int player_id;

    private String name;

    private int nation;

    private String club;

    public Player(String name, int nation, String club) {
        this.name = name;
        this.nation = nation;
        this.club = club;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int id) {
        this.player_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNation() {return nation;}

    public void setNation(int nation) {
        this.nation = nation;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Player{" + "id: " + player_id + ", name: " + name + ", nationality: " + nation +
                ", club: " + club + '}';
    }
}
