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

import com.org.entity.EmployeeAddressClass;
import com.org.respository.EmployeeAddressRepository;
@RestController
@RequestMapping("/emp-address")
public class AddressController {
	@Autowired
	private  EmployeeAddressRepository employeeAddressRepository;
	
	@PostMapping
	public ResponseEntity<String> saveAddress(@RequestBody    EmployeeAddressClass address){
		
		EmployeeAddressClass save = employeeAddressRepository.save(address);
		
		return new ResponseEntity<>("address save",HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<EmployeeAddressClass>> getAllAddress(){
		List<EmployeeAddressClass> findAll = employeeAddressRepository.findAll();
		return new ResponseEntity<>(findAll,HttpStatus.CREATED);
		
	}
	
	

}
