package com.example.dani.dgonzalezapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class PokeDetails {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String name;
}

class Sprites {
    @PrimaryKey (autoGenerate = true)
    public int id;
    public String front_default;
    public String pokeFK;
}