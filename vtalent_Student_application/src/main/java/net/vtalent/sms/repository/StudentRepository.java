package net.vtalent.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.vtalent.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
