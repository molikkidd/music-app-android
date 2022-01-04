package com.example.musicapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.os.Parcelable;
import android.renderscript.Allocation;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SongsActivity extends AppCompatActivity {

   public static ArrayList<String> artistList = new ArrayList<>(Arrays.asList("Wizkid", "Drake", "Davido", "Burna Boy", "Koffee", "Ed Sheeran", "Big Krit", "Kendrick Lamar", "SZA", "Tiwa Savage"));
   public static ArrayList<String> songsList = new ArrayList<>(Arrays.asList("No Stress", "Houston/atl/Vegas", "Ye", "song 4", "song 5", "song 6", "song 7", "song 8", "song 9", "song 10"));
   public static ArrayList<Integer> imageList = new ArrayList<>(Arrays.asList(R.mipmap.wizkid_foreground, R.mipmap.drake_foreground, R.mipmap.davido_foreground, R.mipmap.burnaboy_foreground,
            R.mipmap.koffee_foreground, R.mipmap.edsheeran_foreground, R.mipmap.ic_launcher, R.mipmap.klamar_foreground, R.mipmap.sza_foreground, R.mipmap.tiwasavage_foreground));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
//      make an Array List and pass in the Word object
        ArrayList<Song> songs = new ArrayList<Song>();
        for (int i = 0; i < artistList.size(); i++) {
            String newArtist = artistList.get(i);
            String newSong = songsList.get(i);
            Integer newImage = imageList.get(i);
            songs.add(new Song(newArtist, newSong, newImage));
        }
//       attach Array Adapter to convert ArrayList to a recycled view
        SongAdapter songAdapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
//        set OnClicklistener to each view in the list to play the song.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentArtist = artistList.get(position);
                String currentSong = songsList.get(position);
                Integer currentImage = imageList.get(position);
                Intent i = new Intent(SongsActivity.this, SongsDetailActivity.class);
//                store current song info in the intent so it can be used by songe detail activity
                i.putExtra("currentArtist", currentArtist);
                i.putExtra("currentSong", currentSong);
                i.putExtra("currentImage", currentImage);
                startActivity(i);
            }
        });
//        connect to ListView and set Adapter on each list item
        listView.setAdapter(songAdapter);
    }
}

