package com.example.dani.dgonzalezapp.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeDetails;

import java.util.List;

@Dao
public interface PokeDAO {

    @Insert
    void insert(Poke poke);

    @Insert
    void insertDetails(PokeDetails pokeDetails);

    @Query("SELECT * FROM poke")
    LiveData<List<Poke>> getAllPoke();
}
