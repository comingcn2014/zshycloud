package com.zshy.gateway;


public class HelloWorld {
    private static volatile int flag;

    public static void main(String[] args) {
        flag = 1;
        System.out.println(flag);
    }
}
