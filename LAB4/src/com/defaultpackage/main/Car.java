package com.defaultpackage.main;

/**
 * This class represents a Car. It has two variables: its name (the thread ID) and
 * the Bridge it crosses. It implements {@code Runnable} interface
 * @author Dushan Terzikj
 * @since 02.04.2018
 */
public class Car implements Runnable{

    private String name;
    private Bridge bridge;

    /**
     * Parametrized construcor. Sets the {@code bridge} to the bridge the car
     * is crossing
     * @param bridge
     */
    public Car(Bridge bridge){
        this.bridge = bridge;
    }

    /**
     * @return name of the car
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set the car's name
     * @param name
     */
    public void setName(String name){
        this.name = name;
    }

    @Override
    public void run() {
        this.bridge.crossBridge(this);
    }
}