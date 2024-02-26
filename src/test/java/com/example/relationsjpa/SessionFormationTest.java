package com.example.relationsjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relationsjpa.model.SessionFormation;
import com.example.relationsjpa.repository.SessionFormationRepository;

@SpringBootTest
public class SessionFormationTest {
	@Autowired
	private SessionFormationRepository sessionUn;
	
	@BeforeEach
	void clean () {
		sessionUn.deleteAll();
	}
	
	@Test
	void contextLoad() {
		SessionFormation premiereSession = new SessionFormation();
		premiereSession.setLibelle("CDA2023");
		sessionUn.save(premiereSession);
		}
}
