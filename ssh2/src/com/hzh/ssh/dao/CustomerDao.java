package com.hzh.ssh.dao;

import java.util.List;

import com.hzh.ssh.domain.Customer;


/**
 * Customer持久层接口
 * @author ken
 *
 */
public interface CustomerDao {
	void save(Customer customer);
	
	void update(Customer customer);
	
	void delete(Customer customer);
	
	Customer findbyId(Long cust_id);
	
	List<Customer> findAllByHQL();
	List<Customer> findAllByQBC();
	
	List<Customer> queryByName();
}
