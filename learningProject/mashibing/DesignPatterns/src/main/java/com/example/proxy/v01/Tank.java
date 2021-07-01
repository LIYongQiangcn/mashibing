package com.example.proxy.v01;

import java.util.Random;

/**
 * 不改变move方法的源码，计算此方法的运行时间
 */
public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("tank start ...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable{

    //这里只代理的tank  比较死
    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        tank.move();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

interface Movable{
    void move();
}
