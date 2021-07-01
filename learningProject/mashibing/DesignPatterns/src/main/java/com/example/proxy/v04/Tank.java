package com.example.proxy.v04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法源码呢？
 * 用继承？
 * v01:使用代理
 * v02:代理有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator?
 * v03:代理的对象改成Movable类型-越来越像decorator了        //静态代理
 * v04:很多系统都有日志打印，让log系统不仅：可以代理tank，还可以代理其他系统
 * 使用jdk的动态代理
 */
public class Tank implements Movable {


    /**
     * 模拟坦克移动了一段儿时间
     */
    @Override
    public void move() {
        System.out.println("Tank moving claclacla...");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        //InvocationHandler  翻译：调用处理器
        //reflection 定义：通过二进制字节码分析类的属性和方法
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true"); //反编译代理类，但是这边不知道为什么没生成
        //java自带的动态代理
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHandler(tank));

        m.move();
    }
}

class LogHandler implements InvocationHandler {
    Tank tank;
    public LogHandler(Tank tank) {
        this.tank = tank;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method "+method.getName()+" start..");
        Object o = method.invoke(tank,args);
        System.out.println("method "+method.getName()+" end!");
        return o;
    }
}

interface Movable {
    void move();
}

