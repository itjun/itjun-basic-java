package io.itjun.basic.lambda.future;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFutureTest {

    @Test
    public void test_run() {
        // 使用CompletableFuture将代码放到异步线程中运行
        // 不需要返回结果直接运行
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                // 模拟长时间运行的任务
                System.out.println("异步任务开始...");
                Thread.sleep(2000); // 休眠2秒钟
                System.out.println("异步任务完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("主线程继续运行...");

        // 主线程继续运行
        future.join();
    }

    @Test
    public void test_supply() {
        // 创建一个 CompletableFuture，返回结果为 String
        // supplyAsync 需要返回结果
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            // 这里放置你需要在异步线程中执行的代码
            try {
                System.out.println("async 异步任务开始执行");
                Thread.sleep(2000); // 模拟耗时操作
                return "async 异步任务执行完毕";
            } catch (InterruptedException e) {
                e.printStackTrace();
                return "任务失败";
            }
        });

        // 处理异步任务的结果，而不阻塞主线程
        future.thenAccept(result -> {
            System.out.println("async 异步任务的结果: " + result);
        });

        // 主线程继续执行其他操作
        System.out.println("main 主线程继续执行其他任务");

        // 模拟主线程的一些其他操作
        try {
            Thread.sleep(3000); // 主线程的其他操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main 主线程的任务执行完毕");
    }

}
