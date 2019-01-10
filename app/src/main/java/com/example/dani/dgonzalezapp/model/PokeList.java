package com.example.dani.dgonzalezapp.model;

import android.arch.lifecycle.ViewModel;

import java.util.List;

public class PokeList extends ViewModel {

    public List<Poke> results;

    public List<Poke> getResults() {
        return results;
    }
}
