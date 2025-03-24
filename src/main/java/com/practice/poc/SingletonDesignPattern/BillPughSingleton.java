package com.practice.poc.SingletonDesignPattern;

public class BillPughSingleton {

    private BillPughSingleton(){
    }

    private static class BillPughSingletonBuilder {
        private static final BillPughSingleton SINGLETON = new BillPughSingleton();
    }

    public static BillPughSingleton getSingleton(){
        return BillPughSingletonBuilder.SINGLETON;
    }

}
