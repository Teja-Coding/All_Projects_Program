package com.org.client;

import java.util.Arrays;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import com.org.entity.EmployeeAddressClass;

@Component
public class AddressClient {
	
	@Autowired
	private RestTemplate restTemplate;
	public void saveAddress(List<EmployeeAddressClass> address, Integer id) {
		address.stream().forEach(addres->{
			addres.setId(id);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<EmployeeAddressClass> httpEntity = new HttpEntity<EmployeeAddressClass>(addres,httpHeaders);
			restTemplate.exchange("http://localhost:6060/emp-address",HttpMethod.POST,httpEntity,String.class);
			});
	}
}
