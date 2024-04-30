package net.vtalent.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import net.vtalent.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StudentManagementSystemApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
		System.out.println(studentRepository.getClass().getName());
		
		System.out.println("application started");
	}


	

}
