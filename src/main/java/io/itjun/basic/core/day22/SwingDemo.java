package io.itjun.basic.core.day22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        f.setBounds(300, 100, 500, 400);

        f.setLayout(new FlowLayout());

        JButton but = new JButton("我是一个按钮");

        f.add(but);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setVisible(true);
    }
}
