package com.example.strategy;

import lombok.Data;

@Data
public class Cat implements Comparable<Cat>{
    int weight,height;

    public Cat(int weight, int height){
        this.height = height;
        this.weight = weight;
    }

    public int compareTo(Cat c){
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return 0;
    }

}
