package com.example.spring.v1;

import org.aspectj.lang.annotation.Aspect;

public class TimeProxy {

    public void before() {
        System.out.println("method start.." + System.currentTimeMillis());
    }

    public void after() {
        System.out.println("method stop.. " + System.currentTimeMillis());
    }

}

