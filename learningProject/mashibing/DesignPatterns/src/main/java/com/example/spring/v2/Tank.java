package com.example.spring.v2;

import java.util.Random;

public class Tank {
    public void move() {
        System.out.println("tank start ...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
