package com.example.examprep21_02.service;


import com.example.examprep21_02.model.entity.Artist;
import com.example.examprep21_02.model.entity.ArtistNameEnum;

public interface ArtistService {

    void initArtists();

    Artist findByArtistNameEnum(ArtistNameEnum artistNameEnum);
}
