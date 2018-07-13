package com.ljj.javasimple.proxycache;

import java.util.concurrent.CountDownLatch;

public class CacheTest {

    private static final int TASK_COUNT = 5;
    private static CountDownLatch firstFinish = new CountDownLatch(TASK_COUNT);

    private static CountDownLatch secondFinish = new CountDownLatch(TASK_COUNT);

    public static void main(String[] args) {

        System.out.println("程序开始了.......");

        System.out.println("第一批任务.......");
        ApiPresenter presenter = new ApiPresenter(new CacheView("view1"));
        for (int i = 0; i < TASK_COUNT; i++) {
            presenter.doApi(String.valueOf(1));
        }

        try {
            firstFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("第一批任务结束了.......");
        }

        System.out.println("第二批任务.......");

        ApiPresenter presenter2 = new ApiPresenter(new CacheView("view2"));
        for (int i = 0; i < TASK_COUNT; i++) {
            presenter2.doApi(String.valueOf(1));
        }

        try {
            secondFinish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("第二批任务结束了.......");
        }
        System.out.println("程序结束了.......");
    }

    static class CacheView implements BaseView {
        private String name;

        public CacheView(String name) {
            this.name = name;
        }

        @Override
        public void dostart() {
            System.out.println(name + " start()");
        }

        @Override
        public void doResult(Object o) {
            System.out.println(name + " onResult = " + o.toString());
            if(name.equals("view1")) {
                firstFinish.countDown();
            }else if(name.equals("view2")){
                secondFinish.countDown();
            }
        }

        @Override
        public void doError(String msg) {
            System.out.println(name + " onError = " + msg);
            if(name.equals("view1")) {
                firstFinish.countDown();
            }else if(name.equals("view2")){
                secondFinish.countDown();
            }
        }
    }
}
