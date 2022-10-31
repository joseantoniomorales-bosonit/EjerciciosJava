package com.bosonit.block7crud.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class PersonEntity implements Serializable {
    @Id
    int id;

    @Column
    String name;
    @Column
    String town;
    @Column
    int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "PersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", town='" + town + '\'' +
                ", age=" + age +
                '}';
    }
}
