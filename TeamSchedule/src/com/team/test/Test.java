package com.team.test;

import com.team.controller.NameListService;
import com.team.controller.TeamException;
import com.team.model.Employee;

import java.util.ArrayList;

/**
 * @Description: List service
 * @ClassName: Test
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 11:40
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        NameListService service = new NameListService();
        ArrayList<Employee> employees = service.getEmployees();
        String columns = "ID\t姓名\t\t年龄\t薪水\t\t职位\t\tTID\t状态\t\t奖金\t\t股份\t\t设备";
        System.out.println(columns);
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
        try {
            Employee employee=service.getEmployee(2);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
