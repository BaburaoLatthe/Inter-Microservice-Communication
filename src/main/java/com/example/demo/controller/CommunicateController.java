package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Student;

@RestController
public class CommunicateController {
	
	private RestTemplate restCall;
	
	@Autowired
	public CommunicateController(RestTemplate restTemplate) {
		this.restCall = restTemplate;
	}
	
	@GetMapping(value = "/fetchStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getWelcomeMessage() {
		ResponseEntity<String> response = restCall.getForEntity("http://localhost:8085/student/", String.class);
		return response.getBody();
	}
	
	@GetMapping(value = "/fetch/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() throws URISyntaxException{
		
		URI url = new URI("http://localhost:8085/student/fetch");
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET, url);
		ResponseEntity<List> response = restCall.exchange(requestEntity , List.class);
		return response.getBody();
	}
 }
