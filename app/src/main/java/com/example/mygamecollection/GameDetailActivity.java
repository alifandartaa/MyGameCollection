package com.example.mygamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GameDetailActivity extends AppCompatActivity {
    TextView tvName,tvGenre;
    ImageView imgPhoto;
    public static final String EXTRA_LINK = "extra_link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        String name = getIntent().getStringExtra("name");
        tvName = findViewById(R.id.tv_item_name_detail);
        tvName.setText(name);
        String genre = getIntent().getStringExtra("genre");
        tvGenre = findViewById(R.id.tv_item_genre_detail);
        tvGenre.setText(genre);
        int link = getIntent().getIntExtra(EXTRA_LINK,0);
        imgPhoto = findViewById(R.id.img_item_photo_detail);
        Glide.with(this)
                .load(link)

                .into(imgPhoto);


    }
}
