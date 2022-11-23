package com.example.myapplication.repositories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entities.Nation;

import java.util.List;

@Dao
public interface NationDAO {

    @Query("select * from nation")
    List<Nation> findAll();

    @Insert
    void insert(Nation nation);

    @Update
    void update(Nation nation);

    @Query("select * from nation where name like :name")
    List<Nation> findByName(String name);

    @Delete
    void delete(Nation nation);

}
