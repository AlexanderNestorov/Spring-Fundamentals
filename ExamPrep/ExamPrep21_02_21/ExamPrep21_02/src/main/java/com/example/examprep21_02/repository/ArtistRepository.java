package com.example.examprep21_02.repository;

import com.example.examprep21_02.model.entity.Artist;
import com.example.examprep21_02.model.entity.ArtistNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    Optional<Artist> findByName(ArtistNameEnum name);
}
