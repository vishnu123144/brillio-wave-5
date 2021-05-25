package com.brillio.customer.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brillio.customer.model.Customer;
import com.brillio.customer.service.CustomerService;

@RestController

public class CustomerController {
	@Autowired
	private CustomerService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@PostMapping("saveCustomer")
	public ResponseEntity<Object> saveCustomerDetails(@RequestBody Customer customer){
		Customer cus=service.saveCustomer(customer);
		if(cus!=null) {
			return new ResponseEntity<>(cus,HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("No details saved",HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("customer/{id}")
	public String getCustomerOrderDetails(@PathVariable("id") Long id){
		Customer customer=service.getCustomer(id);
		
		ArrayList list=restTemplate.getForObject("http://ORDER-SERVICE/findCustomer/"+id, ArrayList.class);
		
		return customer.getName()+"-->order details"+ list;
	}
	
	

}
