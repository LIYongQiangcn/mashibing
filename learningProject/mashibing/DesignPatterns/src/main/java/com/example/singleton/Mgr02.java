package com.example.singleton;

/**
 * 懒汉式
 * 线程使用的时候才进行实例化
 * 此处会带来线程不安全问题：多线程同事执行时，会在线if判断的时候，同事创建两个Instance
 */
public class Mgr02 {

    private static Mgr02 INSTANCE;

    private Mgr02() {};

    public static Mgr02 getInstance() {
        if (INSTANCE == null) { //线程不安全
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread( () -> {
                System.out.println(Mgr02.getInstance().hashCode());
            }).start();
        }
    }
}
