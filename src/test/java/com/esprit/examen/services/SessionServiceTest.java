package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;

@SpringBootTest
public class SessionServiceTest {
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	CoursRepository coursRepository;

	private static final Logger l = LogManager.getLogger(SessionServiceTest.class);
	Cours cours = new Cours();
	Formateur formateur = new Formateur();
	long dataBeforeTest;
	public Session session;

	@Test
	public void testaddSession() {
		buildSession();
		sessionRepository.save(session);

		// after
		long dataAfterTest = sessionRepository.count();

		// isEqual
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest - 1);
		sessionRepository.deleteById(session.getId());

	}
	
	@Test
	public void testUpdateSession(){
		buildSession();
		sessionRepository.save(session);
		int totalCours = session.getCours().size();
		//update
		Cours addedCours = new Cours();
		addedCours.setIntitule("Spring Security");
		Set<Cours> cours = session.getCours();
		cours.add(addedCours);		
		session.setCours(cours);
		coursRepository.save(addedCours);
		sessionRepository.save(session);
		assertThat(totalCours+1).isEqualTo(session.getCours().size());
		sessionRepository.delete(session);		
	}

	private void buildSession() {
		formateur.setNom("oussema");
		cours.setIntitule("devops");
		formateurRepository.save(formateur);
		coursRepository.save(cours);
		dataBeforeTest = sessionRepository.count();
		session = new Session();
		Set<Cours> listCours = new HashSet<Cours>();
		listCours.add(cours);
		session.setCours(listCours);
		session.setDateDebut(new Date());
		session.setDateFin(new Date());
		session.setDescription("session 1");
		session.setDuree(2L);
		session.setFormateur(formateur);
		l.info(session);
	}
}