package com.infosystem.test;

import com.infosystem.controller.StudentList;
import com.infosystem.model.Gender;
import com.infosystem.model.Person;
import com.infosystem.model.Student;
import org.junit.jupiter.api.Test;

/**
 * @Description:
 * @ClassName: TestList
 * @Author: QUANWEI
 * @Date: 2021/9/16 12:19
 * @Version: 1.0
 */
public class TestList {
    @Test
    public void test() {
        StudentList studentList = new StudentList();
//        studentList.add(new Student("Tang",1, Gender.Male,18,"哈哈"));
//        studentList.add(new Student("Quanwei",1, Gender.Male,18,"哈哈"));
//        studentList.add(new Student("唐权威",1, Gender.Male,18,"哈哈"));
//        studentList.add(new Student("权威",1, Gender.Male,18,"哈哈"));
        studentList.show();
        studentList.write();
    }
}
