package test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hzh.ssh.domain.Customer;
import com.hzh.ssh.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHDemo01 {
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	// 修改
	public void demo01() {
		Customer customer = customerService.findbyId(1l);
		customer.setCust_name("赵宏");
		customerService.update(customer);
	}
	
	@Test
	// 删除
	public void demo02() {
		Customer customer = customerService.findbyId(1l);
		customerService.delete(customer);
	}
	
	@Test
	// 查询所有HQL
	public void demo03() {
		List<Customer> list = customerService.findAllByHQL();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	@Test
	// 查询所有QBC
	public void demo04() {
		List<Customer> list = customerService.findAllByQBC();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
	@Test
	// queryByName
	public void demo05() {
		List<Customer> list = customerService.queryByName();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
