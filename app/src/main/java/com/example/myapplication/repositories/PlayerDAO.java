package com.example.myapplication.repositories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entities.Player;

import java.util.List;

@Dao
public interface PlayerDAO {
    @Query("select * from player")
    List<Player> findAll();

    @Insert
    void insert(Player player);

    @Update
    void update(Player player);

    @Query("select * from player where name like :name")
    List<Player> findByName(String name);

    @Query("select nation.nation_id from nation where nation.name like :nation")
    int findNation(String nation);

    @Query("select player.* from player " +
            "join nation on nation.nation_id == player.nation where nation.name like :nation")
    List<Player> findByNation(String nation);

    @Delete
    void delete(Player player);
}
