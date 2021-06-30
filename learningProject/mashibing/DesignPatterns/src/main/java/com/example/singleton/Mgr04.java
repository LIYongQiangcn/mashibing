package com.example.singleton;

public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04() {};

    public static Mgr04 getInstance() {
        if (INSTANCE == null) {
            synchronized (Mgr04.class) { //1.只对同步代码块进行加锁时，也会导致线程不安全

                if (INSTANCE == null) { //2.只有进行在锁内再判断，才能保证线程安全
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr04();
                }
                return INSTANCE;
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread( () -> {
                System.out.println(Mgr04.getInstance().hashCode());
            }).start();
        }
    }
}
