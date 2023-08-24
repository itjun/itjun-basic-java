package io.itjun.basic.mongo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Movie {

    String plot;
    List<String> genres;
    String title;

    @Override
    public String toString() {
        return "Movie [\n  plot=" + plot + ",\n  genres=" + genres + ",\n  title=" + title + "\n]";
    }

}