package th.co.maximus.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.Employee;

@Service
public class HelloService {

private JdbcTemplate jdbcTemplate;
	
	public HelloService(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean insert(Employee employee) {
		boolean result = true;
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO student ( studentID, firstname, lastname, email, phone, majorID) ");
		sql.append(" VALUES (?,?) ");
		try {
			jdbcTemplate.update(sql.toString(), employee.getStudentID(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getMajorID());
		}catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	public void update(Employee employee) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE student ");
		sql.append(" SET firstname =  ?, lastname = ?, email = ?, phone = ?, majorID = ? ");
		sql.append(" WHERE studentID = ? ");
		jdbcTemplate.update(sql.toString(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPhone(), employee.getMajorID());
		
	}
	
	public void delete(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE from student ");
		sql.append(" WHERE studentID = ? ");
		jdbcTemplate.update(sql.toString(), id);
	}
	
	public List<Employee> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM student ");
		return jdbcTemplate.query(sql.toString() , new Mapp());
	}
	
	public Employee findByID(long id) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM student where studentID = ");
		sql.append(id);
		return jdbcTemplate.queryForObject(sql.toString() , new Mapp());
	}
	
	private static final class Mapp implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setStudentID(rs.getString("studentID"));
			employee.setFirstName(rs.getString("firstname"));
			employee.setLastName(rs.getString("lastname"));
			employee.setEmail(rs.getString("email"));
			employee.setPhone(rs.getString("phone"));
			employee.setMajorID(rs.getInt("majorID"));
			return employee;
		}

	}
	
}
