package com.example.relationsjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relationsjpa.model.Competence;
import com.example.relationsjpa.repository.CompetenceRepository;

@SpringBootTest
public class CompetenceTest {
	@Autowired
	private CompetenceRepository competenceUn;
	
	@BeforeEach
	void clean () {
		competenceUn.deleteAll();
	}
	
	@Test
	void contextLoad() {
		Competence premiereCompetence = new Competence();
		premiereCompetence.setLibelle("comprendre Spring");	
		premiereCompetence.setNiveau(42);
		competenceUn.save(premiereCompetence);
	}	
}
