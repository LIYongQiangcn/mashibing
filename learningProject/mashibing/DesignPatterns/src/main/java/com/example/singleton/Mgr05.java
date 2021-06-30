package com.example.singleton;

/**
 * 饿汉式  升级
 * 解决避免类加载就实例化对象问题: 静态内部类
 * jvm保证单例：加载外部类时不会加载内部类，这样可以实现懒汉式
 *
 */
public class Mgr05 {
    private Mgr05() {};

    //静态内部类
    private static class Mgr05Holder {
        private static final Mgr05 INSTANCE = new Mgr05();
    }

    public static Mgr05 getInstance() {
        return Mgr05Holder.INSTANCE;
    }

}
