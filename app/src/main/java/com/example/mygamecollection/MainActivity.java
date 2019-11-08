package com.example.mygamecollection;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity{
    private RecyclerView rvGames;
    private ArrayList<Game> list = new ArrayList<>();
    private Button btnShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvGames = findViewById(R.id.rv_games);
        rvGames.setHasFixedSize(true);

        list.addAll(GamesData.getListData());
        showRecyclerList();
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setIcon(R.mipmap.ic_launcher);

        btnShow = findViewById(R.id.btn_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showRecyclerList() {
        rvGames.setLayoutManager(new LinearLayoutManager(this));
        ListGameAdapter listGameAdapter = new ListGameAdapter(list);
        rvGames.setAdapter(listGameAdapter);

        listGameAdapter.setOnItemClickCallback(new ListGameAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Game data) {
                Intent moveIntent = new Intent(MainActivity.this, GameDetailActivity.class);
                moveIntent.putExtra("name",data.getName());
                moveIntent.putExtra("genre",data.getGenre());
                moveIntent.putExtra(GameDetailActivity.EXTRA_LINK,data.getPhoto());
                startActivity(moveIntent);
            }
        });
    }

}
