package com.example.healthmonitoringsystem;

public class VitalIndicator {
    private double weight;
    private int numbersOfSteps;

    public VitalIndicator(double weight, int numbersOfSteps) {
        this.weight = weight;
        this.numbersOfSteps = numbersOfSteps;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNumbersofSteps() {
        return numbersOfSteps;
    }

    public void setNumbersofSteps(int numbersofSteps) {
        this.numbersOfSteps = numbersofSteps;
    }

    @Override
    public String toString() {
        return "VitalIndicator{" +
                "weight=" + weight +
                ", numbersOfSteps=" + numbersOfSteps +
                '}';
    }
}
