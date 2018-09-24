package com.luukas.rules.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luukas.rules.entity.Input;
import com.luukas.rules.services.ResponseService;

@RestController
public class ResponseController {
	
	ResponseService responseService;
	
	@Autowired
	public ResponseController(ResponseService responseService) {
		this.responseService = responseService;
	}
	
	@PostMapping("/target")
	public String getTarget(@RequestBody Map<String, Object> postData) {
		Input info = convertToPostInfo(postData);
		System.out.println(info);
		String target = responseService.generateReponse(info);
		return target;
	}
	
	private Input convertToPostInfo(Map<String, Object> postData) {
		Input info = new Input();
		info.setStrInput1((String)postData.get("strInput1"));
		info.setStrInput2((String)postData.get("strInput2"));
		info.setStrInput3((String)postData.get("strInput3"));
		info.setBoolInput(((Boolean)postData.get("boolInput")).booleanValue());
		info.setIntInput(((Integer)postData.get("intInput")).intValue());
		System.out.println(info);
		return info;
	}
	
}
