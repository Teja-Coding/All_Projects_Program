package net.vtalent.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="student_age")
	private Integer studentAge;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@Column(name = "email")
	private String email;


	public Student(String firstName, String lastName, Integer studentAge, String phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentAge = studentAge;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
}
