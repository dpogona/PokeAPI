package com.example.dani.dgonzalezapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.dani.dgonzalezapp.model.Poke;

import java.util.List;

@Dao
public interface PokeDAO {

    @Insert
    void insert(Poke poke);

    @Query("SELECT * FROM poke ORDER BY id")
    LiveData<List<Poke>> getAllPoke();

    @Query("SELECT * FROM poke WHERE name = :name")
    Poke queryPokemon(String name);

    @Query("SELECT * FROM poke WHERE id = :id")
    LiveData<Poke> queryPokemonById(Integer id);
}
