package com.practice.poc.FactoryDesignPattern;

interface Vehicle{
    void drive();
}

class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("This is Bike");
    }
}

class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("This is Car");
    }
}

class VehicleFactory{

    public static Vehicle getVehicle(String vehicle){
        if(vehicle.equalsIgnoreCase("car")){
            return new Car();
        }else if(vehicle.equalsIgnoreCase("bike")){
            return new Bike();
        }else{
            throw new IllegalArgumentException("Vehicle does not exist");
        }
    }
}
public class FactoryPatternDemo {

    public static void main(String[] args) {
        Vehicle car = VehicleFactory.getVehicle("car");
        car.drive();
    }
}
