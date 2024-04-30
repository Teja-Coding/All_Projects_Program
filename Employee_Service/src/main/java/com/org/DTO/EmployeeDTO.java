package com.org.DTO;

import java.util.List;

import com.org.entity.EmployeeAddressClass;
import com.org.entity.EmployeeClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private EmployeeClass employeeClass;
	
	private List<EmployeeAddressClass>  employeeAddressClass;
	
	
}
