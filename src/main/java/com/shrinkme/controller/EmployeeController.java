package com.shrinkme.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@RequestMapping(value = "/")
	public HashMap<String, Object> test() {
		System.out.println("inside test");
		HashMap<String, Object> result = new HashMap<>();
		result.put("test", 1);
		return result;
	}
	
	@RequestMapping(value = "/user")
	public HashMap<String, Object> testUser() {
		System.out.println("inside user");
		HashMap<String, Object> result = new HashMap<>();
		result.put("user", 1);
		return result;
	}
	
	@RequestMapping(value = "/admin")
	public HashMap<String, Object> testAdmin() {
		System.out.println("inside admin");
		HashMap<String, Object> result = new HashMap<>();
		result.put("admin", 1);
		return result;
	}
}
