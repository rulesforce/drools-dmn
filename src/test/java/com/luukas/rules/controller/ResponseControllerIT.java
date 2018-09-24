package com.luukas.rules.controller;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.luukas.rules.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, 
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
public class ResponseControllerIT {

	@LocalServerPort
	private int port;
	
	TestRestTemplate restTemplate = new TestRestTemplate();
	
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void testGetTarget() {
		
		Map<String, Object> postData = new HashMap<String, Object>();
		postData.put("userId", 4);
		postData.put("strInput1", "Y");
		postData.put("strInput2", "Y");
		postData.put("strInput3", "Y");
		postData.put("boolInput", true);
		postData.put("intInput", 5000);
		postData.put("charInput", "1");
		
		HttpEntity<Map<String, Object>> entity = new HttpEntity<Map<String, Object>>(postData, headers);
		
		String url = "http://localhost:" + port + "/target";
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		String actualTarget = response.getBody();
		assertTrue(actualTarget.equals("Target 5"));
	}
	
	
}
