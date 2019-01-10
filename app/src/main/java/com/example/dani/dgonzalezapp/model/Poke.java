package com.example.dani.dgonzalezapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

@Entity
public class Poke implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    public String id;
    public String name;
    public String url;
}