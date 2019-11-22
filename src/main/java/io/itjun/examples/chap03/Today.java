package io.itjun.examples.chap03;

/**
 * Created by iCrazyTeam on 2016/4/17 0017.
 */
public class Today {
    public static void main(String[] args) {
        String today = TDateTime.Now().getDate();
        String birthday = TDateTime.Now().addDay(60).getDate();
        System.out.println(birthday.compareTo(today));
        System.out.println(today.compareTo(birthday));
    }
}
