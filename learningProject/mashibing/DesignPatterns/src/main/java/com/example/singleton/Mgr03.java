package com.example.singleton;

/**
 * 懒汉式 出现了线程不安全
 * 加锁可以解决线程不安全，但是加锁会导致性能下降
 */
public class Mgr03 {
    private static volatile Mgr03 INSTANCE; //需要加volatile,汇编时的问题，具体比较复杂

    private Mgr03() {};

    public static synchronized Mgr03 getInstance() {
        if (INSTANCE == null) { //线程不安全
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread( () -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }
    }
}
