package io.itjun.examples.thread.lambda;

public class CreateThreadByThreadFactory {
    public static void main(String[] args) {
        UserThreadFactory factory = new UserThreadFactory("localHost");
        Thread thread;
        for (int i = 0; i < 20; i++) {
//            thread = factory.newThread(new MyRunnableThread());// FIRST WAY，每次都创建一个factory对象实例
            //                new MyRunnableThread().run();
            thread = factory.newThread(MyRunnableThread::new);// SECOND WAY,lambda 只调用一个factory对象实例
            thread.start();
        }
    }
}