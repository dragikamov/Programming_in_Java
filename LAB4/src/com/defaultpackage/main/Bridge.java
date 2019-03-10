package com.defaultpackage.main;

import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This is a singleton class representing a bridge. It cointains one instance and 
 * a {@code getInstance()} method. It also contains a {@code Semaphore} which 
 * allows 3 permits (3 cars at a time).
 * @author Dushan Terzikj
 * @since 02.04.2018 
 */
public class Bridge{

    private static Bridge instance = new Bridge();
    private Semaphore sem = new Semaphore(3, true);
    private Random random = new Random();

    private Bridge(){

    }

    /**
     * @return the instance of this bridge
     */
    public static Bridge getInstance(){
        return instance;
    }

    /**
     * Simulator method which simulates a car crossing a bridge
     * @param car
     */
    public void crossBridge(Car car){

        try {
           
            System.out.printf("%s is WAITING to cross the bridge\n", car.getName());
            sem.acquire();
            System.out.printf("%s is CROSSING the bridge\n", car.getName());
            Thread.sleep(random.nextInt(4000));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.printf("%s has FINISHED CROSSING the bridge\n", car.getName());
            sem.release();
        }
    }
}