package com.example.proxy.v02;

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
//日志代理
class TankLogProxy implements Movable{

    @Override
    public void move() {

    }
}

interface Movable{
    void move();
}
