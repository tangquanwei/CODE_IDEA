/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.customer.ui;

import com.customer.bean.Customer;
import com.customer.service.CustomerList;
import com.customer.utli.CMUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 负责菜单的显示和处理用户操作(与用户交互)
 * @ClassName: CustomerView
 * @Author: QUANWEI
 * @Date: 28/08/2021 19:00
 * @Version: 1.0
 */
public class CustomerView {
    private final CustomerList customerList = new CustomerList();
    ArrayList<Customer> costumes=customerList.getCustomerArrayList();
    public void enterMainMenu() {
        lab_while:
        while (true) {

            System.out.println("""
                                        
                    --------客户信息管理系统--------
                                        
                    \t0.退出管理系统
                    \t1.添加客户信息
                    \t2.删除客户信息
                    \t3.修改客户信息
                    \t4.查找客户信息
                    \t5.排序客户信息
                    \t6.显示客户信息

                    \t请输入(1-4):""");
            int choice = CMUtility.readMenuSelection();
            switch (choice) {
                case 0 -> {
                    System.out.print("确定退出(Y/N)? : ");
                    if (CMUtility.readChoice()){
                        customerList.save();
                        break lab_while;
                    }
                }
                case 1 -> {
                    CMUtility.clearScreen();
                    addNewCustomer();
                }
                case 2 -> {
                    CMUtility.clearScreen();
                    deleteCustomer();
                }
                case 3 -> {
                    CMUtility.clearScreen();
                    modifyCustomer();
                }
                case 4 -> {
                    CMUtility.clearScreen();
                    findCustomer();
                }
                case 5 -> {
                    CMUtility.clearScreen();
                    sortCustomer();
                    showCustomer();
                }
                case 6 -> {
                    CMUtility.clearScreen();
                    showCustomer();
                }

            }
        }
    }

    /**
     * @return Customer instance
     * @Description: read user input to construct an instance
     */
    private Customer subAdd() {
        String id = CMUtility.readString(4);
        System.out.println("名字:");
        String name = CMUtility.readString(10);
        System.out.println("性别:");
        String gender = CMUtility.readString(1);
        System.out.println("年龄:");
        int age = CMUtility.readInt();
        System.out.println("电话号码:");
        String phone = CMUtility.readString(11);
        System.out.println("电子邮箱:");
        String email = CMUtility.readString(20);
        return new Customer(id, name, gender, age, phone, email);
    }

    private void addNewCustomer() {
        System.out.println("请输入待添加的客户信息\nID:");
        if (customerList.addCustomer(subAdd()))
            System.out.println("添加成功!");
        else
            System.out.println("添加失败!");
    }

    private void deleteCustomer() {
        System.out.println("删除客户信息");

        int index = findCustomer();
        if (index != -1) {
            System.out.println("确定删除客户信息(Y/N)?");
            if (CMUtility.readChoice())
                if (customerList.deleteCustomer(index))
                    System.out.println("删除成功");
        }
    }

    private void modifyCustomer() {
        System.out.println("修改客户信息");
        int index = findCustomer();
        if (index != -1) {
            if (customerList.replaceCustomer(index, subAdd()))
                System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    private int findCustomer() {
        System.out.print("请输入待查找的客户ID:(-1退出)");
        int index = -1;
        String id = CMUtility.readString(4);
        if (!id.equals("-1")) {
            index = costumes.indexOf(new Customer(id));
            if (index != -1) {
                System.out.println("查找成功");
                System.out.println(costumes.get(index).toString());
            } else {
                System.out.println("未找到该客户信息");
            }
        } else {
            System.out.println("退出查找");
        }
        return index;
    }

    private void sortCustomer() {
//        Arrays.sort(customerList.getCustomers(), Comparator.comparing(Customer::getId));
        costumes.sort(Comparator.comparing(Customer::getId));
    }

    private void showCustomer() {
        System.out.println("---------客户列表--------\n");
        int total = customerList.getTotal();
        if (total == 0) {
            System.out.println("没有客户记录!");
        } else {
            System.out.println("ID\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] customers = customerList.getCustomers();
            for (Customer c : customers) {
                System.out.println(c.getId() + "\t" +
                                   c.getName() + "\t" +
                                   c.getGender() + "\t" +
                                   c.getAge() + "\t" +
                                   c.getPhone() + "\t" +
                                   c.getEmail());
            }
        }
        System.out.println("------------------------\n");

    }


    public static void main(String[] args) {
        CustomerView cv = new CustomerView();
        cv.enterMainMenu();
    }

}

