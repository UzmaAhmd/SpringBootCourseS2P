package com.uzmaaa.MyFirstAPI.model;

public class Movies {
    private Long id;
    private String movieName;
    private String starActor;
    private String villain;
    private Double collection;

    public Movies() {
    }

    public Movies(Long id, String movieName, String starActor, String villain, Double collection) {
        this.id = id;
        this.movieName = movieName;
        this.starActor = starActor;
        this.villain = villain;
        this.collection = collection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getStarActor() {
        return starActor;
    }

    public void setStarActor(String starActor) {
        this.starActor = starActor;
    }

    public String getVillain() {
        return villain;
    }

    public void setVillain(String villain) {
        this.villain = villain;
    }

    public Double getCollection() {
        return collection;
    }

    public void setCollection(Double collection) {
        this.collection = collection;
    }
}
