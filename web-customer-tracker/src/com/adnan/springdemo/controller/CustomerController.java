package com.adnan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adnan.springdemo.dao.CustomerDAO;
import com.adnan.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// need to inject the customerDAO
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		// add the customers to the model
								// name   ,    value
		theModel.addAttribute("customersWichtigLink",theCustomers);
		return "list-customers";
	}
	
}
