package com.example.dani.dgonzalezapp;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;


import com.example.dani.dgonzalezapp.model.Poke;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private PokeRepository pokeRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        pokeRepository = new PokeRepository(application);
    }

    public LiveData<List<Poke>> getPokemons(){
        return pokeRepository.getPokemonList();
    }

    public LiveData<Poke> getPokemon(Integer id) {
        return pokeRepository.getPokemonById(id);
    }
}