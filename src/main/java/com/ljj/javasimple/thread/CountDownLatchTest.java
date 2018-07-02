package com.ljj.javasimple.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    private static final int PLAYER_COUNT = 5;

    public static void main(String[] args) {
        CountDownLatch playStart = new CountDownLatch(1);
        CountDownLatch playEnd = new CountDownLatch(PLAYER_COUNT);

        Player[] players = new Player[PLAYER_COUNT];
        for (int i = 0; i < PLAYER_COUNT; i++) {
            players[i] = new Player("player" + i, playStart, playEnd);
        }

        System.out.println("进入准备阶段===================================");

        ExecutorService executorService = Executors.newFixedThreadPool(PLAYER_COUNT);
        for (int i = 0; i < PLAYER_COUNT; i++) {
            executorService.execute(players[i]);
        }

        try {
            Thread.sleep(1000);//设置一个准备时间阶段，等待所有选手准备完成
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("完成准备阶段===================================");
        playStart.countDown();//触发统一的开跑时间点
        System.out.println("比赛开始================================");

        try {
            playEnd.await();//等待所有选手完成跑步
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("比赛结束=================================");
            executorService.shutdown();//关闭线程池
        }
    }

    private static class Player implements Runnable {
        private String name;
        private CountDownLatch start, end;

        public Player(String name, CountDownLatch start, CountDownLatch end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            System.out.println(name + "准备完成");
            try {
                start.await();//等待start.countDown，触发开始
                int time = (int) (Math.random() * 10000);
                System.out.println(name + "开跑, 需要" + time);
                Thread.sleep(time);//设置当前选手跑步的时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(name + "完成");
                end.countDown();//当前选手完成跑步
            }
        }
    }
}
