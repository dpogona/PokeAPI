package com.example.dani.dgonzalezapp.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dani.dgonzalezapp.GlideApp;
import com.example.dani.dgonzalezapp.R;
import com.example.dani.dgonzalezapp.model.Poke;


import java.util.ArrayList;
import java.util.List;

public class PokeListAdapter extends RecyclerView.Adapter<PokeListAdapter.PokeListViewHolder>{
    public List<Poke> pokeList = new ArrayList<>();
    FragmentActivity activity;


    public PokeListAdapter(FragmentActivity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public PokeListViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);

        final PokeListViewHolder pokeListViewHolder = new PokeListViewHolder(view);

        return new PokeListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final @NonNull PokeListViewHolder holder, int position) {
        final Poke poke = pokeList.get(position);

        holder.tv_pokename.setText(poke.name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), PokeActivity.class);
                intent.putExtra("url", poke.url);
                intent.putExtra("id", poke.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });

        GlideApp.with(holder.itemView.getContext()).load(poke.sprites.front_default).into(holder.imatge);
    }

    @Override
    public int getItemCount() {
        return pokeList.size();
    }

    public Poke getPosition(int i) {
        return pokeList.get(i);
    }


    class PokeListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pokename;
        ImageView imatge;

        public PokeListViewHolder(View itemView) {
            super(itemView);
            tv_pokename = itemView.findViewById(R.id.name);
            imatge = itemView.findViewById(R.id.imagen);
        }
    }
}