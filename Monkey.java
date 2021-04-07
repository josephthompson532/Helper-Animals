package com.example.awtExample;

import java.lang.String;

public class Monkey extends RescueAnimal{

    // Instance Variables
    private int tailLength;
    private int height;
    private int bodyLength;
    private String species;

    public Monkey(String name, String species, String gender, String age, String weight, String acquisitionDate,
                  String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry,
                  int tailLength, int height, int bodyLength) {
        super(name, "Monkey", gender, age, weight, acquisitionDate, acquisitionCountry,
                trainingStatus, reserved, inServiceCountry);
        this.tailLength=tailLength;
        this.height=height;
        this.bodyLength=bodyLength;
        this.species=species;

    }

    public int getTailLength() {
        return tailLength;
    }

    public void setTailLength(int tailLength) {
        this.tailLength = tailLength;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }


}
