package com.example.dani.dgonzalezapp.api;
import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeList;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PokedbAPI {
    @GET("/api/v2/pokemon/")
    Call<PokeList> getPokemonList();

    @GET
    Call<Poke> getPokemon(@Url String url);
}