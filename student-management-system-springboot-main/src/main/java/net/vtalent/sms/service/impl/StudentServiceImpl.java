package net.vtalent.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.vtalent.sms.entity.Student;
import net.vtalent.sms.repository.StudentRepository;
import net.vtalent.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);	
	}

}
