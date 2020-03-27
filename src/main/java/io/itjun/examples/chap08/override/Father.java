package io.itjun.examples.chap08.override;

/**
 * Created by itjun on 2016/5/5 0005.
 */
public class Father {
    private String messge;

    public Father() {
        System.out.println("Father...");
    }

    public Father(String message) {
        this.setMessge(message);
        System.out.println("Father....Message....");
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }
}
