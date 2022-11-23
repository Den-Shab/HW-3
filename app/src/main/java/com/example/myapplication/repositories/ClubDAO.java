package com.example.myapplication.repositories;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.entities.Club;

import java.util.List;

@Dao
public interface ClubDAO {
    @Query("select * from club")
    List<Club> findAll();

    @Insert
    void insert(Club club);

    @Update
    void update(Club club);

    @Query("select * from club where name like :name")
    List<Club> findByName(String name);

    @Delete
    void delete(Club club);
}
