package com.example.dani.dgonzalezapp.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dani.dgonzalezapp.MainViewModel;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Poke;
import com.example.dani.dgonzalezapp.model.PokeDetails;

import java.text.MessageFormat;


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

        tv_name = findViewById(R.id.name);
        tv_id = findViewById(R.id.id);
        iv_imagen = findViewById(R.id.imagen);

        pokeViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        pokeViewModel.getPokemon(url).observe(this, new Observer<PokeDetails>() {
            @Override
            public void onChanged(@Nullable PokeDetails poke) {
                tv_name.setText(poke.name);

                int size = poke.id;
                if(size == 1 )tv_id.setText(MessageFormat.format("#00{0}", poke.id));
                else if (size == 2)tv_id.setText(MessageFormat.format("#0{0}", poke.id));
                else tv_id.setText(MessageFormat.format("#{0}", poke.id));

                /*Glide.with(PokeActivity.this)
                        .load(poke.sprites.get(0).front_default)
                        .into(iv_imagen);*/
            }
        });
    }
}