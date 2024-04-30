package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.DTO.EmployeeDTO;
import com.org.client.AddressClient;
import com.org.entity.EmployeeAddressClass;
import com.org.entity.EmployeeClass;
import com.org.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp-service")
public class EmployeeControler {
	@Autowired
	private EmployeeRepository  employeeRepository;
	
	@Autowired
	private AddressClient addressClient;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody  EmployeeDTO employeeDTO){
		
		EmployeeClass save = employeeRepository.save(employeeDTO.getEmployeeClass());
		if(save != null && save.getId()>0) {
			addressClient.saveAddress(employeeDTO.getEmployeeAddressClass(),save.getId());
		}
		
		
		return new ResponseEntity<String>("Employee"+save.getName()+" saved successfully with id: "+save.getId(),HttpStatus.CREATED);
		
	}
	@GetMapping
	public ResponseEntity<List<EmployeeClass>> getAllEmployee(){
		
		List<EmployeeClass> findAll = employeeRepository.findAll();
		return new ResponseEntity<>(findAll,HttpStatus.CREATED);
	}
}
