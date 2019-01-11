package com.example.dani.dgonzalezapp.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity
public class Poke implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    public Integer id;
    public String name;
    public String url;


    @Embedded
    public Sprite sprites;

    public static class Sprite {
        public String front_default;
    }
}