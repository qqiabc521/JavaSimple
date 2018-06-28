package com.ljj.javasimple.pattern.singleton;

/**
 * 第一次加载Singleton类时并不会初始化sInstance，
 * 只有第一次调用getInstance方法时虚拟机加载SingletonHolder 并初始化sInstance ，
 * 这样不仅能确保线程安全也能保证Singleton类的唯一性，所以推荐使用静态内部类单例模式。
 *
 * @author lijunjie
 */
public class StaticInnerSingleton {
    private StaticInnerSingleton() {
    }

    public static StaticInnerSingleton getInstance() {
        return StaticInnerSingletonHolder.instance;
    }

    private static class StaticInnerSingletonHolder {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }
}
