package com.example.factotyMethod;

/**
 * 交通工具工厂
 * 简单工厂: 可扩展性不好，每次添加一个交通工具时，都要添加很多代码
 */

public class SimpleVehicleFactory {

    public Car createCar(){
        return new Car();
    }

    public Plane createPlane(){
        return new Plane();
    }

}
