package com.example.relationsjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relationsjpa.model.Apprenant;
import com.example.relationsjpa.model.DossierAdministratif;
import com.example.relationsjpa.repository.ApprenantRepository;
import com.example.relationsjpa.repository.DossierAdministratifRepository;

@SpringBootTest
public class DossierAdminTest {
	@Autowired
	private DossierAdministratifRepository dossierUn;
	
	@Autowired
	private ApprenantRepository apprenantDoss;
	
	@BeforeEach
	void clean () {
		dossierUn.deleteAll();
		apprenantDoss.deleteAll();
	}
	
	@Test
	void contextLoads() {
		
		Apprenant lepremierApprenantDoss = new Apprenant();
		lepremierApprenantDoss.setNom("PORTO");
		lepremierApprenantDoss.setPrenom("Rico");
		apprenantDoss.save(lepremierApprenantDoss);
		
		
		DossierAdministratif lepremier = new DossierAdministratif();
		lepremier.setTuteurNom("Roger");
		lepremier.setTuteurEmail("roger@rogermail.fr");
		lepremier.setApprenant(lepremierApprenantDoss);
		dossierUn.save(lepremier);
		
	}	
}
