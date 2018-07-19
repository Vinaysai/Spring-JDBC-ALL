package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.jdbc.bean.Employee;
import com.spring.jdbc.mapper.Employeemapper;

@Component
public class EmployeeDao implements EmployeeDaoInterface {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int create(Employee employee) {

		String sql = "insert into javadatabase.employeesample values(?,?,?,?)";
		int rs = jdbcTemplate.update(sql,
				new Object[] { employee.getEmpid(), employee.getName(), employee.getAge(), employee.getSalary() });
		System.out.println("In Create:::");
		System.out.println("Created new record:::" + employee.getEmpid() + "" + employee.getName() + ""
				+ employee.getAge() + "" + employee.getSalary());
		return rs;

	}

	public Employee getdetails(Integer empid) {
		Employee employee = new Employee();

		String sql = "select *from javadatabase.employeesample where id=?";
		return employee = jdbcTemplate.queryForObject(sql, new Object[] { empid }, new Employeemapper());

	}

	public List<Employee> list() {
		String sql = "select *from javadatabase.employeesample";
		List<Employee> emp = jdbcTemplate.query(sql, new Employeemapper());
		return emp;

	}

	public void delete(Integer empid) {

		String sql = "delete from javadatabase.employeesample where id=?";

		jdbcTemplate.update(sql, new Object[] { empid });

		System.out.println("deleted" + empid);
	}

	public void update(Integer empid, Integer age) {

		String sql = "update javadatabase.employeesample set age=? where id=?";

		jdbcTemplate.update(sql, new Object[] { empid, age });

		System.out.println("Updated Record with EMPID = " + empid + "age is " + age);
	}
}
