package com.hzh.ssh.service;

import java.util.List;

import com.hzh.ssh.domain.Customer;

/**
 * 客户管理的业务接口
 * @author ken
 *
 */
public interface CustomerService {
	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	Customer findbyId(Long cust_id);
	
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();
	
	List<Customer> queryByName();
}
