package com.example.examprep21_02.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{
    private ArtistNameEnum name;
    private String careerInformation;

    public Artist() {
    }

    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }

    @Column(nullable = true, columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
