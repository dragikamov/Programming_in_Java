package com.company.test;
import com.company.Pet;

public class Test{

    public static void main(String args[]){

        Pet pet = new Pet();
        System.out.println(pet.toString());
        pet.setName("Jackie");
        pet.setNumOfLegs(4);
        pet.setType("Dog");
        System.out.println(pet.toString());

        Pet pet2 = new Pet("Johnny", 4, "Cat");
        System.out.println(pet2.toString());
        System.out.println(pet2.getName());
        System.out.println(pet2.getNumOfLegs());
        System.out.println(pet2.getType());
    }
}