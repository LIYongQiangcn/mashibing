package com.example.factotyMethod;

/**
 * 形容词用接口，名称用抽象类
 * 任意定制交通工具
 *   1.继承 moveable 接口
 * 任意定制生产过程
 *   1.Moveable XXXFactory.create()
 */

public class Main {
    public static void main(String[] args) {
        Moveable c = new Car(); // new Plane（）
        c.go();

        //通过car工厂创建交通工具
        Moveable b = new CarFactory().createCar();
    }
}
