package com.adnan.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.adnan.springdemo.entity.Customer;



@Repository
public class CustomerDaoImplemetaion implements CustomerDAO {

	// need to inject the Hibernate session factory

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		// create a query
		Query<Customer> theQuery = session.createQuery("from customer", Customer.class);
		// execute the query
		List<Customer> customers = theQuery.getResultList();
		// return the list of Customers
		return customers;
	}

}
