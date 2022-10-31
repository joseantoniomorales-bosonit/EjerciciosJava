package com.bosonit.block7crud.component;

import org.springframework.stereotype.Component;

@Component
public class PersonComponent {
    private String name;
    private String town;
    private int age;

    public PersonComponent(String name, String town, int age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public PersonComponent(){
        this.name = "";
        this.town = "";
        this.age = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
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
