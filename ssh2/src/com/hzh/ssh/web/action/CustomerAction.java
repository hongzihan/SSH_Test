package com.hzh.ssh.web.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hzh.ssh.domain.Customer;
import com.hzh.ssh.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户管理的Action的类
 * @author ken
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	// 注入CustomerService
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return NONE;
	}
	
	/**
	 * 保存客户的方法: save
	 */
	public String saveCustomer() {
		// 如果web层没有使用Struts2,获取业务层的类就必须如下进行编写
//		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
//		CustomerService customerService = (CustomerService) webApplicationContext.getBean("customerService");
		customerService.save(customer);
		System.out.println("Action中的save方法执行了……");
		return NONE;
	}
	
	/**
	 * 测试延迟加载
	 */
	public String findById() {
		Customer customer = customerService.findbyId(2l);
		System.out.println(customer);
		return NONE;
	}
	
}
