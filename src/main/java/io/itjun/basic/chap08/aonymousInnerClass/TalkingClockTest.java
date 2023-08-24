package io.itjun.basic.chap08.aonymousInnerClass;

import javax.swing.*;

/**
 * This Program demonstrates anonymous inner class
 * <p>
 * Created by itjun on 2016/6/26 0026.
 */
public class TalkingClockTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
