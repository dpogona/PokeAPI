package com.example.dani.dgonzalezapp.DAO;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeDetails;


@Database(entities = {Poke.class, PokeDetails.class}, version = 8)
public abstract class PokeDatabase extends RoomDatabase{

    public abstract PokeDAO pokeDao();

    private static volatile PokeDatabase INSTANCE;



    public static PokeDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PokeDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PokeDatabase.class, "poke_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
