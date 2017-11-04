package com.pluralsight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.pluralsight.model.Customer;

public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${dbUsername}")
	private String dbUsername;
	/* (non-Javadoc)
	 * @see com.pluralsight.repository.CustomerRepository#findAll()
	 */
	public List<Customer> findAll() {
		System.out.println(dbUsername);
		
		List<Customer> customers = new ArrayList<Customer>();
		
		Customer cu = new Customer();
		cu.setFirstname("Ivana");
		cu.setLastname("Frankic");
		
		customers.add(cu);
		
		return customers;
	}
}
