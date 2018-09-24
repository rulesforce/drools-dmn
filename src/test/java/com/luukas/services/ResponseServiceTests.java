package com.luukas.services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luukas.rules.Application;
import com.luukas.rules.entity.Input;
import com.luukas.rules.services.ResponseService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class ResponseServiceTests {
	
	@Autowired 
	private ResponseService responseService;

	@Test
	public void testGenerateResponse_rule1Triggered() {
		Input response = new Input();
		response.setStrInput1("N");
		response.setStrInput2("Y");
		response.setStrInput3("Y");
		
		String target = responseService.generateReponse(response);
		assertTrue(target.equalsIgnoreCase("Target 1"));
	}
	
	@Test
	public void testGenerateResponse_rule3Triggered() {
		Input response = new Input();
		response.setStrInput1("Y");
		response.setStrInput2("Y");
		response.setStrInput3("N");
		
		String target = responseService.generateReponse(response);
		assertTrue(target.equalsIgnoreCase("Target 3"));
	}
	
	@Test
	public void testGenerateResponse_rule5Triggered() {
		Input response = new Input();
		response.setStrInput1("Y");
		response.setStrInput2("Y");
		response.setStrInput3("Y");
		response.setBoolInput(true);
		response.setIntInput(8000);
		
		String target = responseService.generateReponse(response);
		System.out.println("target: " + target);
		assertTrue(target.equalsIgnoreCase("Target 5"));
	}
}
