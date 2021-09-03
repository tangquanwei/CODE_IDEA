package com.customer.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Description: JavaBean实体对象, 封装客户信息
 * @ClassName: Customer
 * @Author: QUANWEI
 * @Date: 2021/8/29 12:40
 * @Version: 2.0
 */

public class Customer implements Serializable {
    private String id;
    private String name;
    private String gender;
    private int age;
    private String phone;
    private String email;

    public Customer() {
    }

    public Customer(String id, String name, String gender,
                    int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\nid:\t" + getId() +
               "\nname:\t" + getName() +
               "\ngender:\t" + getGender() +
               "\nage:\t" + getAge() +
               "\nphone:\t" + getPhone() +
               "\nemail:\t" + getEmail();
    }
}
