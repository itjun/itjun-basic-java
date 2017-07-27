package chap08.innerClass;

import javax.swing.*;

/**
 * This program demonstrates the use of inner class.
 * <p>
 * Created by iCrazyTeam on 16/6/24.
 */
public class TalkingClockTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }

}
