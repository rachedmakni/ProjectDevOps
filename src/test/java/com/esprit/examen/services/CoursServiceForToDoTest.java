package com.esprit.examen.services;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//Affectation TESTs

@SpringBootTest
class CoursServiceForToDoTest {
	/*@Autowired
	ICoursService coursService;	
	@Autowired
	ISessionService sessionService;
	@Autowired
	CoursRepository coursRepository;
	private static final Logger l = LogManager.getLogger(CoursServiceForToDoTest.class);
	@Test
	void testAffect() {
		Cours cours = new Cours();
		coursService.addCours(cours);
		Session session =new Session();
		sessionService.addSession(session);
		l.info(cours.getId());
		l.info(session.getId());
		coursService.affecterCoursASession(cours.getId(), session.getId());
    	Cours coursAfterAffect = coursRepository.findById((long)cours.getId());
		l.info(coursAfterAffect.getSessions());
		l.info(cours);
		assertTrue(coursAfterAffect.getSessions().contains(session));
		coursService.supprimerCours(cours.getId());
	}*/


}
