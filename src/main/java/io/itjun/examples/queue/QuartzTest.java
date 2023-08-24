package io.itjun.examples.queue;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 测试Quartz不同设置的执行流程
 */
@Component
public class QuartzTest {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    int[] delays = new int[]{8, 7, 6, 3, 2, 1, 1, 5, 1, 1, 1};
    int index = 0;

    @Scheduled(cron = "0/5 * * * * ?")
//    @Scheduled(fixedRate = 5 * 1000)
//    @Scheduled(fixedDelay = 5 * 1000)
    public void process() {
        try {
            if (index > delays.length - 1) {
                if (index == delays.length) {
                    System.out.println("---------- test end at " + dtf.format(LocalTime.now()) + " ---------");
                }
                index++;
                return;
            } else {
                System.out.println(delays[index] + "秒");
                System.out.println(index + ":start run at " + dtf.format(LocalTime.now()));
            }
            Thread.sleep(delays[index] * 1000);
            System.out.println(index + ":end run at " + dtf.format(LocalTime.now()));
            System.out.println();
            index++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}