package com.practice.poc.SingletonDesignPattern;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getLazyInstance(){
        if(instance == null){
            System.out.println("First time object creation");
            instance = new LazySingleton();
        }
        return instance;
    }
}
