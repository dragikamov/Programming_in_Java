package com.defaultpackage.test;

import java.util.Random;

import com.defaultpackage.main.Bridge;
import com.defaultpackage.main.Car;

/**
 * This is a test driver class for the classes Bridge and Car
 * @author Dushan Terzikj
 * @since 02.04.2018
 */
public class TestDriver{

    public static void main(String[] args) {
        
        Bridge bridge = Bridge.getInstance();
        Random random = new Random();

        Thread south = new Thread(new Runnable(){
        
            @Override
            public void run() {
                
                while(true){
                    Car car = new Car(bridge);
                    Thread cThread = new Thread(car);
                    car.setName("South " + cThread.getId());
                    cThread.start();
    
                    try {
                        Thread.sleep(random.nextInt(4000));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        south.start();
    }
}