package io.itjun.examples.chap07;

/**
 * Created by iCrazyTeam on 16/5/26.
 */
public class StartMessage {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadMessage());
        for (int i = 0; i < 5; i++) {
            if (i % 2 != 0) {
                thread.run();
            }
        }
    }
}
