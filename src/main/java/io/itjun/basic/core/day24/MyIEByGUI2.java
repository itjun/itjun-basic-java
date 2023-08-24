package io.itjun.basic.core.day24;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class MyIEByGUI2 {
    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okBut;

    MyIEByGUI2() {
        init();
    }

    public static void main(String[] args) {
        new MyIEByGUI2();
    }

    public void init() {
        f = new Frame("my window");
        f.setBounds(300, 100, 600, 500);
        f.setLayout(new FlowLayout());

        tf = new TextField(60);

        but = new Button("转到");

        ta = new TextArea(25, 70);

        d = new Dialog(f, "提示信息-self", true);
        d.setBounds(400, 200, 240, 150);
        d.setLayout(new FlowLayout());
        lab = new Label();
        okBut = new Button("确定");

        d.add(lab);
        d.add(okBut);

        f.add(tf);
        f.add(but);
        f.add(ta);

        myEvent();
        f.setVisible(true);
    }

    private void myEvent() {

        okBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER)
                        showDir();
                } catch (Exception ex) {
                }

            }
        });

        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showDir();
                } catch (Exception ex) {
                }

            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    private void showDir() throws Exception {

        ta.setText("");
        String urlPath = tf.getText();// http://192.168.1.254:8080/myweb/demo.html

        URL url = new URL(urlPath);

        URLConnection conn = url.openConnection();

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        ta.setText(new String(buf, 0, len));

    }
}
