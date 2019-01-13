package com.hzh.ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.hzh.ssh.dao.CustomerDao;
import com.hzh.ssh.domain.Customer;
import com.hzh.ssh.utils.HibernateUtils;

/**
 * CustomerDao实现类
 * @author ken
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		System.out.println("dao的方法被执行");
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(customer);
	}

	@Override
	public void delete(Customer customer) {
		this.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer findbyId(Long cust_id) {
		//return this.getHibernateTemplate().get(Customer.class, cust_id);
		return this.getHibernateTemplate().load(Customer.class, cust_id);
	}

	@Override
	public List<Customer> findAllByHQL() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer");
		return list;
	}

	@Override
	public List<Customer> findAllByQBC() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

	@Override
	public List<Customer> queryByName() {
		return (List<Customer>) this.getHibernateTemplate().findByNamedQuery("queryAll");
	}
}
