package com.arkbackendarkgroup.controller;

import com.arkbackendarkgroup.model.Employee;
import com.arkbackendarkgroup.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {


	//Required to Generate JSON content from Java objects
	public static final ObjectMapper mapper = new ObjectMapper();

	//Directly invoke the APIs interacting with the DB
	@Autowired
	private EmployeeRepository employeeRepository;


	//Test RestTemplate to invoke the APIs.
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@Before
	public void setup(){

	}

	@Test
	public void testEmployeeCreateApi() throws JsonProcessingException {

		//Building the Request body data

		Map<String,Object> requestBody = new HashMap<>();
		requestBody.put("name","karan");
		requestBody.put("designation","engineer");
		requestBody.put("salary",10000);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);

		//Creating http entity object with request body and headers

		HttpEntity<String> httpEntity = new HttpEntity<String>(
				mapper.writeValueAsString(requestBody),httpHeaders
		);

		//Invoking the API
		Map<String,Object> apiResponse =
				restTemplate.postForObject("http://localhost:8080/employees",
						httpEntity,Map.class, Collections.EMPTY_MAP);

		Assert.assertNotNull(apiResponse);

		//Asserting the response of the API.

	   String message =	apiResponse.get("message").toString();
	   Assert.assertEquals("Employee created successfully",message);

	   Long empId = (Long)((Map<String, Object>)apiResponse.get("employee")).get("empId");

	   Assert.assertNotNull(empId);

		//Fetching the Employee details directly from the DB to verify the API succeeded
		Employee employeeFromdb = employeeRepository.getOne(empId);
		Assert.assertEquals("karan",employeeFromdb.getName());
		Assert.assertEquals("engineer",employeeFromdb.getDesignation());
		Assert.assertTrue(1000==employeeFromdb.getSalary());


		//Delete the data added for testing

	   employeeRepository.deleteById(empId);


	}

	@After
	public void destroy(){

	}
}