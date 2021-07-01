package com.example.abstractFactory;

/**
 * 抽象工厂
 */

public abstract class AbstractFactory {
    //3个抽象产品
    abstract Food createFood();
    abstract Vehicle createVehicle();
    abstract Weapon createWeapon();
}
