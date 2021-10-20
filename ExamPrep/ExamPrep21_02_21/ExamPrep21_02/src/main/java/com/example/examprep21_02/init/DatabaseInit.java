package com.example.examprep21_02.init;

import com.example.examprep21_02.service.ArtistService;
import com.example.examprep21_02.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final ArtistService artistService;
    private final UserService userService;

    public DatabaseInit(ArtistService artistService, UserService userService) {
        this.artistService = artistService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        artistService.initArtists();
        userService.initAdmin();
    }
}
