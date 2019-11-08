package com.example.mygamecollection;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

//Adapter ListGame
public class ListGameAdapter extends RecyclerView.Adapter<ListGameAdapter.ListViewHolder>{
    //ArrayList
    private ArrayList<Game> listGame;
    private OnItemClickCallback onItemClickCallback;

    //Constructor List
    public ListGameAdapter (ArrayList<Game> list) {
        this.listGame = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_game, viewGroup, false);
        return new ListViewHolder(view);
    }

    //onBindViewHolder untuk posisi item
    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position){
        Game game = listGame.get(position);
        Glide.with(holder.itemView.getContext())
                .load(game.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(game.getName());
        holder.tvFrom.setText(game.getGenre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listGame.get(holder.getAdapterPosition()));
            }
        });
    }

    //Method return jumlah list
    @Override
    public int getItemCount() {
        return listGame.size();
    }


    //ViewHolder yang berisi source gambar dan teks
    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvFrom;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvFrom = itemView.findViewById(R.id.tv_item_genre);
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Game data);
    }
}
