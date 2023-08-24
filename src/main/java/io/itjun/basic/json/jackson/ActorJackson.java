package io.itjun.basic.json.jackson;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class ActorJackson {

    @Getter
    @Setter
    private String imdbId;

    @Getter
    @Setter
    private Date dateOfBirth;

    @Getter
    @Setter
    private List<String> filmography;

    public ActorJackson(String imdbId, Date dateOfBirth, List<String> filmography) {
        this.imdbId = imdbId;
        this.dateOfBirth = dateOfBirth;
        this.filmography = filmography;
    }

}