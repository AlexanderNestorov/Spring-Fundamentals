package com.example.examprep21_02.service;

import com.example.examprep21_02.model.entity.Album;
import com.example.examprep21_02.model.service.AlbumServiceModel;
import com.example.examprep21_02.model.view.AlbumViewModel;
import com.example.examprep21_02.repository.AlbumRepository;
import com.example.examprep21_02.security.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ArtistService artistService;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.artistService = artistService;
    }

    @Override
    public void addAlbum(AlbumServiceModel albumServiceModel) {

        Album album  = modelMapper.map(albumServiceModel, Album.class);

        album.setAddedFrom(userService.findById(currentUser.getId()));
        album.setArtist(artistService.findByArtistNameEnum(albumServiceModel.getArtist()));

        albumRepository.save(album);

    }

    @Override
    public List<AlbumViewModel> findAllAlbumsByCopiesDesc() {
        return albumRepository.findAllByOrderByCopiesDesc()
                .stream()
                .map(album -> modelMapper.map(album, AlbumViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
