package com.customer.service;

import com.customer.bean.Customer;

import java.util.Arrays;

/**
 * @Description: Customer对象的管理模块,内部用数组管理一组Customer
 * @ClassName: CustomerList
 * @Author: QUANWEI
 * @Date: 2021/8/29 12:39
 * @Version: 1.0
 */

public class CustomerList {
    private final Customer[] customers;
    private int total;//number of customers

    public int getTotal() {
        return total;
    }

    public CustomerList(int total) {
        customers = new Customer[total];
    }

    public boolean addCustomer(Customer customer) {
        if (total == customers.length)
            return false;
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customers[total - 1];
        customers[total - 1] = null;
        --total;
        return true;
    }

    public Customer[] getCustomers() {
        return Arrays.copyOf(customers, total);
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }
}
