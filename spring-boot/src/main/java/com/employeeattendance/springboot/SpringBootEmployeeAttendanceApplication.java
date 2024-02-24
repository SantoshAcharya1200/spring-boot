package com.employeeattendance.springboot;

import com.employeeattendance.springboot.model.Employee;
import com.employeeattendance.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootEmployeeAttendanceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeAttendanceApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();

		employee1.setFirst_name("John");
		employee1.setMiddle_name("Doe");
		employee1.setLast_name("Smith");
		employee1.setGender("Male");
		employee1.setAge(30);
		employee1.setAddress("123 Main St");
		employee1.setContact_details("john@example.com");
		employeeRepository.save(employee1);

		employee2.setFirst_name("Johnny");
		employee2.setMiddle_name("Do2n");
		employee2.setLast_name("Smithy");
		employee2.setGender("Male");
		employee2.setAge(31);
		employee2.setAddress("123 Main St");
		employee2.setContact_details("john@example.com");
		employeeRepository.save(employee2);





	}
}
