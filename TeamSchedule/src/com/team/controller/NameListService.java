package com.team.controller;

import com.team.model.*;

import java.util.ArrayList;

/**
 * @Description: 将Data中的数据封装到Employee数组中
 * @ClassName: NameListService
 * @Author: Quanwei Tang
 * @Date: 2021/9/2 10:28
 * @Version: 1.0
 */
public class NameListService {
    //? java final 引用 ???
    private final ArrayList<Employee> employees;

    /**
     * 1.由Data类得到不同对象
     * 2.将对象添加到ArrayList
     */
    public NameListService() {
        employees = new ArrayList<>(Data.EMPLOYEES.length);
        for (String[] i : Data.EMPLOYEES) {
            int type = Integer.parseInt(i[0]);
            int id = Integer.parseInt(i[1]);
            String name = i[2];
            int age = Integer.parseInt(i[3]);
            double salary = Double.parseDouble(i[4]);
            Equipment equipment;
            double bonus;
            switch (type) {
                case Data.EMPLOYEE:
                    employees.add(new Employee(id, name, age, salary));
                    break;
                case Data.PROGRAMMER:
                    equipment = createEquipment(id-1);
                    employees.add(new Programmer(id, name, age, salary, equipment));
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(id-1);
                    bonus = Double.parseDouble(i[5]);
                    employees.add(new Designer(id, name, age, salary, equipment, bonus));
                    break;
                case Data.ARCHITECT:
                    equipment = createEquipment(id-1);
                    bonus = Double.parseDouble(i[5]);
                    int stock = Integer.parseInt(i[6]);
                    employees.add(new Architect(id, name, age, salary, equipment, bonus, stock));
                    break;
            }
        }
    }

    private Equipment createEquipment(int index) {
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type) {
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }
        return null;
    }

    /**
     * @return ArrayList<Employee>
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        throw new TeamException("找不到指定员工");
    }
}
