package com.example.dani.dgonzalezapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dani.dgonzalezapp.MainViewModel;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Poke;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private PokeListAdapter mPokeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.pokeList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mPokeListAdapter = new PokeListAdapter(this);
        mRecyclerView.setAdapter(mPokeListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getPokemons().observe(this, new Observer<List<Poke>>() {
            @Override
            public void onChanged(@Nullable List<Poke> pokes) {
                mPokeListAdapter.pokeList = pokes;
                mPokeListAdapter.notifyDataSetChanged();
            }
        });
    }
}