package chap08.aonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by iCrazyTeam on 2016/6/26 0026.
 */
public class TalkingClock {
    /**
     * Starts the clock.
     *
     * @param interval the interval between messages (in milliseconds)
     * @param beep     beep true if the clock should beep
     */
    public void start(int interval, final boolean beep) {
        ActionListener listener = (e) -> {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(interval, listener);
        t.start();
    }

}
