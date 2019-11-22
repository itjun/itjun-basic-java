package io.itjun.examples.chap02;

/**
 * Created by iCrazyTeam on 2016/10/5 0005.
 */
public class Season {
    public static void main(String[] args) {
        getSeason(7);
    }

    private static void getSeason(int x) {
        switch (x) {
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;

            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;

            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;

            case 12:
            case 1:
            case 2:
                System.out.println("Winter");
                break;

            default:
                System.out.println("No this Session!");
        }
    }

}
