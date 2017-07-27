package chap08.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * A clock that prints the regular intervals.
 * <p>
 * Created by iCrazyTeam on 16/6/24.
 */
public class TalkingClock {
    private int interval;
    private boolean beep;

    /**
     * Constructs a talking clock
     *
     * @param interval the interval between message (in milliseconds)
     * @param beep     true if the clock should beep
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * Starts the clock.
     */
    public void start() {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    /**
     * Define the innerClass TimePrinter
     */
    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Date now = new Date();
            System.out.println("At the tone, the time is " + now);
            if (beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
