package com.jammu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jammu.Repository.EmployeeRepository;
import com.jammu.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   
    @Autowired private EmployeeRepository empRepo;
 
     public List<Employee> getAllEmployees()
    {
        return empRepo.findAll();
    }
 
     public void save(Employee employee)
    {
        empRepo.save(employee);
    }
 
     public Employee getById(Long id)
    {
        Optional<Employee> optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                "Employee not found for id : " + id);
        return employee;
    }
 
     public void deleteViaId(long id)
    {
        empRepo.deleteById(id);
    }

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
    }
