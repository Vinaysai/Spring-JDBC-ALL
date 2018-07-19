package com.spring.jdbc.main;

import java.util.List;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.bean.Employee;
import com.spring.jdbc.dao.EmployeeDao;

public class EmployeeMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		Employee employee = new Employee();

		employee.setAge(23);
		employee.setEmpid(1);
		employee.setName("vinay");
		employee.setSalary(10000);

		EmployeeDao dao = (EmployeeDao) applicationContext.getBean("employeeDaoImpl");

		// Create..
		dao.create(employee);

		// List
		System.out.println("------Listing Multiple Records--------");

		List<Employee> employes = dao.list();
		for (Employee employee2 : employes) {
			System.out.println(employee2);
		}

		// update

		dao.update(1, 24);

		// delete
		dao.delete(3);

		// get details.
		dao.getdetails(2);
	}

}
