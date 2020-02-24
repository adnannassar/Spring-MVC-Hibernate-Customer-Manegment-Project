package com.adnan.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adnan.springdemo.dao.CustomerDAO;
import com.adnan.springdemo.entity.Customer;


@Service
public class CustomerServiceImplementaion implements CustomerService {

	// need to inject the CustomerDAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional // we let the service use the DAO to get the customers
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional // we let the service use the DAO to get the customers
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
	}


	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}


	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return  customerDAO.searchCustomers(theSearchName);
	
	}
}