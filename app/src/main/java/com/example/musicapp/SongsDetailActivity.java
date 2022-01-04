package com.example.musicapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SongsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_details);
//        grab the stored data from the intent bundle
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String song = extras.getString("currentSong");
            String artist = extras.getString("currentArtist");
            Integer image = extras.getInt("currentImage");
//set data to its view
            TextView songName = findViewById(R.id.songName);
            songName.setText(song);
            TextView artistName = findViewById(R.id.artistName);
            artistName.setText(artist);
            ImageView artistImage = findViewById(R.id.artistImage);
            artistImage.setImageResource(image);
        }
//        grab the next and prev button views
        Button nextSong = findViewById(R.id.nextButton);
        Button prevSong = findViewById(R.id.prevButton);
//        implement functions for next and prev
    }
}
