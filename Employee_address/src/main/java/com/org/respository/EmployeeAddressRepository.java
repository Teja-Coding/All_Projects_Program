package com.org.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.entity.EmployeeAddressClass;
@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddressClass, Integer> {

}
