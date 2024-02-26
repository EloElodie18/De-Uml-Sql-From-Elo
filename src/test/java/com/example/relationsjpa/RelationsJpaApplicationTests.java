package com.example.relationsjpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.relationsjpa.model.Apprenant;
import com.example.relationsjpa.model.Competence;
import com.example.relationsjpa.model.DossierAdministratif;
import com.example.relationsjpa.model.SessionFormation;
import com.example.relationsjpa.repository.ApprenantRepository;
import com.example.relationsjpa.repository.CompetenceRepository;
import com.example.relationsjpa.repository.DossierAdministratifRepository;
import com.example.relationsjpa.repository.SessionFormationRepository;

@SpringBootTest
class RelationsJpaApplicationTests {
	
	@Autowired
	private ApprenantRepository apprenant;
	
	@Autowired
	private CompetenceRepository competApp;
	
	@Autowired
	private DossierAdministratifRepository dossAdmin;
	
	@Autowired
	private SessionFormationRepository sessForm;
	
	@BeforeEach
	void clean () {
		apprenant.deleteAll();
		competApp.deleteAll();
		dossAdmin.deleteAll();
		sessForm.deleteAll();
	}
	
	@Test
	void contextLoads() {
		
		//AJOUT DE SESSION
		SessionFormation sessionFormation2023 = new SessionFormation(); 
		sessionFormation2023.setLibelle("session Formation 2023");
		sessForm.save(sessionFormation2023);	
		
		
		//AJOUT DE COMPETENCES
		Competence competenceOne = new Competence();
		competenceOne.setLibelle("comprendre le TP");
		competenceOne.setNiveau(4800);
		competApp.save(competenceOne);
		
		Competence competenceTow = new Competence();
		competenceTow.setLibelle("comprendre Spring");
		competenceTow.setNiveau(7000);
		competApp.save(competenceTow);
				
		
		//AJOUT DOSSIER ADMIN
		DossierAdministratif dossUn = new DossierAdministratif();
		dossUn.setTuteurNom("Barbe bleu");
		dossUn.setTuteurEmail("barbe@bleu.com");
		dossAdmin.save(dossUn);
		
		DossierAdministratif dossDeux = new DossierAdministratif();
		dossDeux.setTuteurNom("Blanche Neige");
		dossDeux.setTuteurEmail("blanche@neige.com");
		dossAdmin.save(dossDeux);
		
		DossierAdministratif dossTrois = new DossierAdministratif();
		dossTrois.setTuteurNom("Belle bête");
		dossTrois.setTuteurEmail("belle@bete.com");
		dossAdmin.save(dossTrois);
		
		
		//AJOUT APPRENANTS
		
		Apprenant leo = new Apprenant();
		leo.setNom("LEON");
		leo.setPrenom("Leo");
		leo.setSession(sessionFormation2023);
		leo.getCompetences().add(competenceOne);	
		apprenant.save(leo);
		
		Apprenant lea = new Apprenant();
		lea.setNom("LION");
		lea.setPrenom("lea");
		lea.setSession(sessionFormation2023);
		lea.getCompetences().add(competenceTow);
		apprenant.save(lea);
		
		Apprenant louis = new Apprenant();
		louis.setNom("LOURS");
		louis.setPrenom("Louis");
		louis.setSession(sessionFormation2023);
		louis.getCompetences().add(null);
		apprenant.save(louis);		
		
		
		//AJOUT APPRENANT A DOSS ADMIN
		dossUn.setApprenant(leo);
		dossAdmin.save(dossUn);
		
		dossDeux.setApprenant(lea);
		dossAdmin.save(dossDeux);
		
		dossTrois.setApprenant(louis);
		dossAdmin.save(dossTrois);				
		
	}
}
