package com.example.healthmonitoringsystem;

public class User {
    private String FIO;
    private int age;

    public User(String FIO, int age) {
        this.FIO = FIO;
        this.age = age;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "FIO='" + FIO + '\'' +
                ", age=" + age +
                '}';
    }
}
