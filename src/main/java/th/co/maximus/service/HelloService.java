package th.co.maximus.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.Employee;

@Service
public class HelloService {

private JdbcTemplate jdbcTemplate;
	
	public HelloService(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Employee employee) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO student ( studentID, firstname, lastname, email, phone, majorID) ");
		sql.append(" VALUES (?,?) ");
		jdbcTemplate.update(sql.toString(), employee.getStudentID(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getMajorID());
	}
	
	public void update(Employee employee) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE student ");
		sql.append(" SET firstname =  ?, lastname = ?, email = ?, phone = ?, majorID = ? ");
		sql.append(" WHERE studentID = ? ");
		jdbcTemplate.update(sql.toString(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getMajorID());
		
	}
	
}
