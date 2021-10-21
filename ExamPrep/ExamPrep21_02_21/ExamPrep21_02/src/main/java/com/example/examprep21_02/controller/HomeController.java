package com.example.examprep21_02.controller;

import com.example.examprep21_02.model.view.AlbumViewModel;
import com.example.examprep21_02.security.CurrentUser;
import com.example.examprep21_02.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping()
    public String index(Model model) {

        if(currentUser.getId() == null) {
            return "index";
        }

        List<AlbumViewModel> albums = albumService.findAllAlbumsByCopiesDesc();

        model.addAttribute("albums", albums);
        model.addAttribute("totalCopies", albums
                .stream()
                .map(AlbumViewModel::getCopies)
                .reduce(Integer::sum)
                .orElse(0)
        );

        return "home";
    }
}
