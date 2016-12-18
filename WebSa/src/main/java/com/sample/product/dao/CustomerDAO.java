package com.sample.product.dao;

import java.util.List;

import com.sample.product.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getList();
	public void insert(Customer manager);

	public Customer get(long id);
	
	public Customer get(String name);
	
	public void update(Customer manager);
	
	public void delete(long id);

	public int count();

}//ProductDAO

