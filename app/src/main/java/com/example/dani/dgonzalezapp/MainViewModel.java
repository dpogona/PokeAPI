package com.example.dani.dgonzalezapp;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeDetails;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private PokedbRepository pokedbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        pokedbRepository = new PokedbRepository();
    }

    public LiveData<List<Poke>> getPokemons(){
        return pokedbRepository.getPokemonList();
    }

    public LiveData<PokeDetails> getPokemon(String url) {
        return pokedbRepository.getPokemon(url);
    }
}