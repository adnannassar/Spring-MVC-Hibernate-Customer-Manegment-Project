package com.adnan.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adnan.springdemo.dao.CustomerDAO;
import com.adnan.springdemo.entity.Customer;
import com.adnan.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	// need to inject the CustomerService
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		// add the customers to the model
								// name   ,    value
		theModel.addAttribute("customersWichtigLink",theCustomers);
		return "list-customers";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	
	//<!-- it will send the data to "saveCustomer" with help from the attribute "customer" -->
	//<form:form action="saveCustomer" modelAttribute="customer" method="POST">
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer in database using our service
		customerService.saveCustomer(theCustomer);
		
		// go back to customer/list page
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId , Model theModel) {
		
		// delete the customer using the service
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
				
		// add the customers to the model
		theModel.addAttribute("customersWichtigLink",theCustomers);
	
		return "list-customers";	
	}
	
	
	
	
	
}
