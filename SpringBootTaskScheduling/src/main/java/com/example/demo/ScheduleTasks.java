package com.example.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 2000)
    public void scheduleTaskWithFixedRate() {
        System.out.println("Scheduled fixedRate Task :: Execution Time :: "+ formatter.format(LocalDateTime.now()) );
    }

    @Scheduled(fixedDelay = 2000)
    public void scheduleTaskWithFixedDelay() {
        System.out.println("Scheduled fixedDelay Task :: Execution Time ::" + formatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println("Error Occured" + ex);
            throw new IllegalStateException(ex);
        }
    }

   @Scheduled(fixedRateString = "${fixedrate.in.milliseconds}", initialDelayString = "${initialDelay.in.milliseconds}")

    @Scheduled(fixedRate = 2000, initialDelay = 5000)
    public void scheduleTaskWithInitialDelay() {
        System.out.println("Scheduled fixedRate Task with initialDelay:: Execution Time::" + formatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "0 15 10 * * *")
    public void scheduleTaskWithCronExpression() {
        System.out.println("Scheduled Cron Task :: Execution Time ::" + formatter.format(LocalDateTime.now()));
    }
}
