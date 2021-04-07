package com.example.awtExample;

// make dog inherit from RescueAnimal
public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;


    // Constructor

    public Dog(String name, String breed, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        // Initialize any dogs "animalType" to dog.
        super(name, "Dog", gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry);
        this.breed=breed;

    }

    // Accessor Method
    public String getBreed() {
        return breed;
    }

    // Mutator Method
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

}
