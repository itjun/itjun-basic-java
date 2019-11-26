package io.itjun.examples.json.jackjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Slf4j
public class JackJsonToObject {

    public static void main(String[] args) throws ParseException, JsonProcessingException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        ActorJackson rudyYoungblood = new ActorJackson("nm2199632", sdf.parse("21-09-1982"),
                Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
        Movie movie = new Movie("tt0472043", "Mel Gibson", Arrays.asList(rudyYoungblood));
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writeValueAsString(movie);
        log.info("{}", jsonResult);
    }

}
