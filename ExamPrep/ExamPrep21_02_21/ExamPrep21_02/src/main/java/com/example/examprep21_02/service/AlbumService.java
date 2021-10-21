package com.example.examprep21_02.service;

import com.example.examprep21_02.model.service.AlbumServiceModel;
import com.example.examprep21_02.model.view.AlbumViewModel;

import java.util.List;

public interface AlbumService {

    void addAlbum(AlbumServiceModel albumServiceModel);

    List<AlbumViewModel> findAllAlbumsByCopiesDesc();

    void deleteAlbum(Long id);
}
