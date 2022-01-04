package com.example.musicapp;

import android.graphics.drawable.Drawable;

import java.util.List;

public class Song {

    private String mArtistName;
    private String mSongName;
    private Integer mArtistImage;

    public Song(String artistList, String songList, Integer imageList) {
        mArtistName = artistList;
        mSongName = songList;
        mArtistImage = imageList;
    }
    public String getArtistName() {
        return mArtistName;
    }
    public String getSongName() {
        return mSongName;
    }
    public Integer getArtistImage() {
        return mArtistImage;
    }
}
