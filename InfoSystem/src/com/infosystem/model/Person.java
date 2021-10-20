package com.infosystem.model;

import java.io.Serializable;

/**
 * @Description: person
 * @ClassName: Person
 * @Author: QUANWEI
 * @Date: 2021/9/16 11:13
 * @Version: 1.0
 */
public class Person implements Comparable<Person>, Serializable {
    private int id;
    private String name;
    private int age;
    private Gender gender;


    public Person(String name, int id, Gender gender, int age) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return id - o.id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
