package com.customer.service;

import com.customer.bean.Customer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: Customer对象的管理模块, 内部用数组管理一组Customer
 * @ClassName: CustomerList
 * @Author: QUANWEI
 * @Date: 2021/8/29 12:39
 * @Version: 2.0
 */

public class CustomerList {
    private final ArrayList<Customer> customers;

    public CustomerList(int total) {
        customers = new ArrayList<>(total);
    }

    public int getTotal() {
        return customers.size();
    }

    public boolean addCustomer(Customer customer) {
        return customers.add(customer);
    }

    public boolean deleteCustomer(int index) {
        return customers.remove(customers.get(index));
    }

    public boolean replaceCustomer(int index, Customer customer) {
        return Collections.replaceAll(customers, customers.get(index), customer);
    }

    public Customer[] getCustomers() {
        Customer[] customersA = new Customer[customers.size()];
        return customers.toArray(customersA);
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customers;
    }
}

