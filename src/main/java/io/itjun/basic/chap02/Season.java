package io.itjun.basic.chap02;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Season {

    public static void main(String[] args) {
        getSeason(5);
    }

    private static void getSeason(int month) {
        switch (month) {
            case 3:
            case 4:
            case 5:
                log.info("{}", "Spring");
                break;

            case 6:
            case 7:
            case 8:
                log.info("{}", "Summer");
                break;

            case 9:
            case 10:
            case 11:
                log.info("{}", "Autumn");
                break;

            case 12:
            case 1:
            case 2:
                log.info("{}", "Winter");
                break;

            default:
                log.info("{}", "No this Session!");
        }
    }

}
