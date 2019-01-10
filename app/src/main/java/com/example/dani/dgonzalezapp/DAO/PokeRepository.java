package com.example.dani.dgonzalezapp.DAO;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.example.dani.dgonzalezapp.api.PokedbAPI;
import com.example.dani.dgonzalezapp.api.PokedbModule;
import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeDetails;
import com.example.dani.dgonzalezapp.model.PokeList;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeRepository {
    PokedbAPI pokeAPI;
    PokeDAO pokeDao;
    private final Executor executor = Executors.newFixedThreadPool(2);

    public PokeRepository(Context context){
        pokeAPI = PokedbModule.getAPI();
        pokeDao = PokeDatabase.getDatabase(context).pokeDao();
    }

    public LiveData<List<Poke>> getPokemonList(){
        refreshPokemonList();
        return pokeDao.getAllPoke();
    }

    public void refreshPokemonList() {
        pokeAPI.getPokemonList().enqueue(new Callback<PokeList>() {
            @Override
            public void onResponse(Call<PokeList> call, final Response<PokeList> response) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        for(Poke poke : response.body().results){
                            updatePokemon(poke);
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<PokeList> call, Throwable t) {
            }
        });
    }

    public void updatePokemon(final Poke poke){
        pokeAPI.getPokemon(poke.url).enqueue(new Callback<PokeDetails>() {
            @Override
            public void onResponse(Call<PokeDetails> call, final Response<PokeDetails> response) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        pokeDao.insertDetails(response.body());
                    }
                });
            }

            @Override
            public void onFailure(Call<PokeDetails> call, Throwable t) {
            }
        });
    }
}
