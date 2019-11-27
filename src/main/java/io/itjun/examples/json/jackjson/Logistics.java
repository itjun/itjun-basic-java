package io.itjun.examples.json.jackjson;

import lombok.Getter;
import lombok.Setter;

public class Logistics {

    @Setter
    @Getter
    private String resultcode;

    @Setter
    @Getter
    private String reason;

    @Setter
    @Getter
    private LogisticsInfo result;

    @Setter
    @Getter
    private String error_code;

}
