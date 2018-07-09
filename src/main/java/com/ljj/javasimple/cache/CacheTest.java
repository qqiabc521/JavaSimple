package com.ljj.javasimple.cache;

public class CacheTest {

    public static void main(String[] args) {
        ApiPresenter presenter = new ApiPresenter(new CacheView("view1"));
        for (int i = 0; i < 5; i++) {
            presenter.doApi(String.valueOf(2));
        }

        ApiPresenter presenter2 = new ApiPresenter(new CacheView("view2"));
        for (int i = 0; i < 5; i++) {
            presenter2.doApi(String.valueOf(1));
        }
    }

    static class CacheView implements BaseView {
        private String name;

        public CacheView(String name) {
            this.name = name;
        }

        @Override
        public void start() {
            System.out.println(name + " start()");
        }

        @Override
        public void onResult(Object o) {
            System.out.println(name + " onResult = " + o.toString());
        }

        @Override
        public void onError(String msg) {
            System.out.println(name + " onError = " + msg);
        }
    }
}
