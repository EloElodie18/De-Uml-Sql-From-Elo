package com.example.relationsjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relationsjpa.model.Apprenant;
import com.example.relationsjpa.model.SessionFormation;
import com.example.relationsjpa.repository.ApprenantRepository;
import com.example.relationsjpa.repository.SessionFormationRepository;

@SpringBootTest
public class ApprenantTest {
	@Autowired
	private ApprenantRepository apprenant;
	
	@Autowired
	private SessionFormationRepository sessionApp;
		
	@BeforeEach
	void clean () {
		apprenant.deleteAll();
		sessionApp.deleteAll();
	}
	
	@Test
	void contextLoads() {
		
		SessionFormation sessionDeux = new SessionFormation();
		sessionDeux.setLibelle("CDA 2040");
		sessionApp.save(sessionDeux);
		
		Apprenant first = new Apprenant();
		first.setNom("RIO");
		first.setPrenom("Janeiro");
		first.setSession(sessionDeux);
		apprenant.save(first);
		
		Apprenant second = new Apprenant();
		second.setNom("REPUBLIQUE");
		second.setPrenom("Dominicaine");
		apprenant.save(second);
		
		Apprenant third = new Apprenant();
		third.setNom("COSTA");
		third.setPrenom("Rica");
		apprenant.save(third);
		
	}

}
