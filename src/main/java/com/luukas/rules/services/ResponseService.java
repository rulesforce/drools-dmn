package com.luukas.rules.services;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luukas.rules.entity.Output;
import com.luukas.rules.entity.Input;

@Service
public class ResponseService {
	
	private final KieContainer kieContainer;
	
	@Autowired
	public ResponseService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	public String generateReponse(Input response) {

		KieSession kieSession = kieContainer.newKieSession("ksession-dtables");

		Output output = new Output();
		kieSession.insert(output);
		kieSession.insert(response);
		kieSession.fireAllRules();
		kieSession.dispose();

		System.out.println("output target:" + output.getTarget());
		System.out.println("output comment:" + output.getComment());
		
		return output.getTarget();
	}
}
