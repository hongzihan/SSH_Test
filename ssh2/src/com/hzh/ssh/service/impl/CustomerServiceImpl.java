package com.hzh.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.hzh.ssh.dao.CustomerDao;
import com.hzh.ssh.domain.Customer;
import com.hzh.ssh.service.CustomerService;

/**
 * CustomerService实现类
 * 
 * @author ken
 *
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
	// 注入Dao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
		System.out.println("Service中的save方法执行了……");
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public Customer findbyId(Long cust_id) {
		Customer customer = customerDao.findbyId(cust_id);
		return customer;
	}

	@Override
	public List<Customer> findAllByHQL() {
		return customerDao.findAllByHQL();
	}

	@Override
	public List<Customer> findAllByQBC() {
		return customerDao.findAllByQBC();
	}

	@Override
	public List<Customer> queryByName() {
		return customerDao.queryByName();
	}

}
