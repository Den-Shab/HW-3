package com.example.myapplication;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.entities.Nation;
import com.example.myapplication.entities.Club;
import com.example.myapplication.entities.Player;
import com.example.myapplication.repositories.ClubDAO;
import com.example.myapplication.repositories.NationDAO;
import com.example.myapplication.repositories.PlayerDAO;

@androidx.room.Database(entities = {Nation.class, Player.class, Club.class}, version = 1)
public abstract class Database extends RoomDatabase{

    private static Database INSTANCE;

    public abstract NationDAO nationDAO();
    public abstract ClubDAO clubDAO();
    public abstract PlayerDAO playerDAO();

    public static Database getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), Database.class, "Footballers")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
