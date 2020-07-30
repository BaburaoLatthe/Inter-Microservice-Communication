package com.example.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Student;

@RestController
public class CommunicateController {
	
	@Value(value = "${microservice.h2.url}")
	private String h2ServiceBaseUrl;
	
	private RestTemplate restCall;
	
	@Autowired
	public CommunicateController(RestTemplate restTemplate) {
		this.restCall = restTemplate;
	}
	
	@GetMapping(value = "/fetchStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getWelcomeMessage() {
		ResponseEntity<String> response = restCall.getForEntity(MessageFormat.format("{0}/student/", h2ServiceBaseUrl), String.class);
		return response.getBody();
	}
	
	@GetMapping(value = "/fetch/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() throws URISyntaxException{
		
		// Use UriComponentsBuilder for getting URI
		URI uri = UriComponentsBuilder.fromHttpUrl(MessageFormat.format("{0}/student/fetch", h2ServiceBaseUrl))
									  .encode(Charset.forName("UTF-8"))
									  .build()
									  .toUri();
		
		
		RequestEntity<Object> requestEntity = new RequestEntity<>(HttpMethod.GET,uri);
		ResponseEntity<List> response = restCall.exchange(requestEntity , List.class);
		return response.getBody();
	}
 }
