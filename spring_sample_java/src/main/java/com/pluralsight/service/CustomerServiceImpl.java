package com.pluralsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Customer;
import com.pluralsight.repository.CustomerRepository;

@Service("customerService")
@Scope("prototype") // singleton vs. prototype // web-erlated scopes are: request, session and globalsession
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
		
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("Inside constructor injection");
		this.customerRepository = customerRepository;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.pluralsight.service.CustomerService#findALl()
	 */
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("Inside setter injection");
		this.customerRepository = customerRepository;
	}
}
