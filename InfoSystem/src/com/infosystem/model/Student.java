package com.infosystem.model;

/**
 * @Description: s
 * @ClassName: Student
 * @Author: QUANWEI
 * @Date: 2021/9/16 11:22
 * @Version: 1.0
 */
public class Student extends Person{
    private String info;

    public Student(String name, int id, Gender gender, int age, String info) {
        super(name, id, gender, age);
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString()+
                "info='" + info + '\'' +
                '}';
    }
}
