package io.itjun.examples.json.jackson;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class LogisticsInfo {

    @Setter
    @Getter
    private String company;

    @Setter
    @Getter
    private String com;

    @Setter
    @Getter
    private String no;

    @Setter
    @Getter
    private String status;

    @Setter
    @Getter
    private List<LogisticsTrace> list;

}
