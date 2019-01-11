package com.example.dani.dgonzalezapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.MainViewModel;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Poke;

import java.text.MessageFormat;
import java.util.List;


public class PokeActivity extends AppCompatActivity {

    private MainViewModel pokeViewModel;

    TextView tv_name;
    TextView tv_id;
    ImageView iv_imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_show);

        final String url = getIntent().getExtras().getString("url");
        final Integer id = getIntent().getExtras().getInt("id");

        tv_name = findViewById(R.id.name);
        tv_id = findViewById(R.id.id);
        iv_imagen = findViewById(R.id.imagen);

        pokeViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        pokeViewModel.getPokemon(id).observe(this, new Observer<Poke>() {
            @Override
            public void onChanged(@Nullable Poke poke) {
                tv_name.setText(poke.name);

                tv_id.setText(MessageFormat.format("#{0}", id));

                Glide.with(PokeActivity.this)
                        .load(poke.sprites.front_default)
                        .into(iv_imagen);
            }
        });
    }
}