package com.example.spring.v1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml里面具体操作切面
 */

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");
        Tank tank = (Tank) context.getBean("Tank");
        tank.move();
    }
}
