package com.spring.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.bean.Employee;

public class Employeemapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

		Employee employee = new Employee();
		employee.setEmpid(rs.getInt("id"));
		employee.setAge(rs.getInt("age"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getInt("salary"));

		return employee;
	}

}
