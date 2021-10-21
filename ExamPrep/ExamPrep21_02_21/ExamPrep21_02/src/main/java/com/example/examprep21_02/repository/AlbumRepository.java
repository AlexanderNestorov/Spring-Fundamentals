package com.example.examprep21_02.repository;

import com.example.examprep21_02.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    List<Album> findAllByOrderByCopiesDesc();
}
