package io.itjun.examples.desig.patterns.single;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QimenClient {

    private String client_id;
    private String client_secret;

    public QimenClient(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

}
