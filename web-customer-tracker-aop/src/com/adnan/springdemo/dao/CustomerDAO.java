package com.adnan.springdemo.dao;

import java.util.List;

import com.adnan.springdemo.entity.Customer;

public interface CustomerDAO {
	List<Customer> getCustomers();

	void saveCustomer(Customer theCustomer);

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

	List<Customer> searchCustomers(String theSearchName);
}
