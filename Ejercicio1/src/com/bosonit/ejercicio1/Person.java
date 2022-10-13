package com.bosonit.ejercicio1;

public class Person {
    private String name,town;
    private int age;

    //CONSTRUCTOR
    public Person(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    //GETTERS
    public String getName() {
        return name;
    }
    public String getTown() {
        return town;
    }
    public int getAge() {
        return age;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }
}
