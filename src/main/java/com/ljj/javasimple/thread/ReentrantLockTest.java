package com.ljj.javasimple.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Function: 两个线程交替执行打印 1~100
 */
public class ReentrantLockTest {
    private volatile int count = 0;
    private volatile boolean flag = false;

    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread thread1 = new Thread(new OneTask(test));
        Thread thread2 = new Thread(new TwoTask(test));

        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        thread1.start();
        thread2.start();
    }

    private static class OneTask implements Runnable {
        private ReentrantLockTest test;

        public OneTask(ReentrantLockTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            while (true) {
                LOCK.lock();
                try {
                    if (test.count >= 100) {
                        break;
                    }
                    if (test.flag) {
                        test.count++;
                        test.flag = false;
                        System.out.println(Thread.currentThread().getName() + " count = " + test.count);
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }

    private static class TwoTask implements Runnable {
        private ReentrantLockTest test;

        public TwoTask(ReentrantLockTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            while (true) {
                LOCK.lock();
                try {
                    if (test.count >= 100) {
                        break;
                    }
                    if (!test.flag) {
                        test.count++;
                        test.flag = true;
                        System.out.println(Thread.currentThread().getName() + " count = " + test.count);
                    }
                } finally {
                    LOCK.unlock();
                }
            }
        }
    }


}
