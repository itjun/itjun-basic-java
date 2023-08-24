package io.itjun.basic.json.jackson;

import lombok.Getter;
import lombok.Setter;

public class LogisticsTrace {

    @Setter
    @Getter
    private String datetime;

    @Setter
    @Getter
    private String remark;

    @Setter
    @Getter
    private String zone;

}
