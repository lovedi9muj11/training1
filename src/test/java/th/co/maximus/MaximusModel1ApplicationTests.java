package th.co.maximus;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import th.co.maximus.bean.Employee;
import th.co.maximus.service.HelloService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaximusModel1ApplicationTests {
	
	@Autowired HelloService helloService;

	@Test
	public void contextLoads() {
	}
	
	@Ignore
	@Test
	public void insert() {
		Employee employee = new Employee();
		employee.setStudentID("6100000");
		employee.setFirstName("firstName");
		employee.setLastName("lastName");
		employee.setEmail("Email");
		employee.setPhone("08000000000");
		employee.setMajorID(1);
		helloService.insert(employee);
	}
	
	@Ignore
	@Test
	public void update() {
		Employee employee = new Employee();
		employee.setStudentID("6100000");
		employee.setFirstName("firstNameUpdate");
		employee.setLastName("lastName");
		employee.setEmail("Email");
		employee.setPhone("08000000000");
		employee.setMajorID(1);
		helloService.update(employee);
	}
	
	@Ignore
	@Test
	public void delete() {
		Employee employee = new Employee();
		employee.setStudentID("6100000");
		helloService.delete(employee.getStudentID());
	}
	
	@Ignore
	@Test
	public void findAll() {
		List<Employee> employee = helloService.findAll();
		assertThat(employee).isNotEmpty();
	}
	
	@Ignore
	@Test
	public void findById() {
		Employee employee = new Employee();
		employee.setStudentID("6100000");
		Employee result = helloService.findByID(employee.getStudentID());
		assertThat(result).isNotNull();
	}

}
