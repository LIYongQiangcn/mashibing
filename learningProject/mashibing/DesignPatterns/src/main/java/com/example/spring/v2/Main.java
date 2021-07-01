package com.example.spring.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 注解来控制切面
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank) context.getBean("Tank");
        tank.move();
    }
}
