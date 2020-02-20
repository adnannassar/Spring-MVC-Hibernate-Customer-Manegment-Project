package com.adnan.springdemo.dao;

import java.util.List;

import com.adnan.springdemo.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();
}
