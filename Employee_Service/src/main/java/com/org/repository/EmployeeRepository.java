package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.EmployeeClass;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeClass	, Integer> {

}
