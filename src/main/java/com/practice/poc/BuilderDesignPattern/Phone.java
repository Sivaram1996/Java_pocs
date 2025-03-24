package com.practice.poc.BuilderDesignPattern;

public class Phone {

    private double cost;
    private String model;
    private boolean is5gEnabled;

    private Phone(PhoneBuilder phoneBuilder){
        this.cost = phoneBuilder.cost;
        this.is5gEnabled = phoneBuilder.is5gEnabled;
        this.model = phoneBuilder.model;
    }

    public static class PhoneBuilder{
        private double cost;
        private String model;
        private boolean is5gEnabled;

        public PhoneBuilder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public PhoneBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public PhoneBuilder setIs5gEnabled(boolean is5gEnabled) {
            this.is5gEnabled = is5gEnabled;
            return this;
        }

        public Phone build(){
            return new Phone(this);
        }
    }
}
