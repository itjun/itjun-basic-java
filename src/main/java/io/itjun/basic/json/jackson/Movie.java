package io.itjun.basic.json.jackson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Movie {

    @Getter
    @Setter
    private String imdbId;

    @Getter
    @Setter
    private String director;

    @Getter
    @Setter
    private List<ActorJackson> actors;

    public Movie() {
    }

    public Movie(String imdbId, String director, List<ActorJackson> actors) {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }

}