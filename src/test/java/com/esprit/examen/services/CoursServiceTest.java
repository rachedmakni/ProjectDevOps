package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//CRUD TESTs

@SpringBootTest
class CoursServiceTest {
	@Autowired
	ICoursService coursService;
	@Autowired
	CoursRepository coursRepository;
	private static final Logger l = LogManager.getLogger(CoursServiceTest.class);


	
	@Test
	void testAddCours() {
		Cours cours = newCours();
		long dataBeforeTest = coursRepository.count();
		l.info("before " + dataBeforeTest);
		coursService.addCours(cours);
		l.info(cours);
		l.debug("saving");
		long dataAfterTest = coursRepository.count();
		l.info("after " + dataAfterTest);
		// isEqual
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest - 1);
		// assertTrue(dataBeforeTest==dataAfterTest-1);
		coursService.addCours(cours);
	}

	@Test
	void testUpdateCours() {
		Cours cours = newCours();
		coursService.addCours(cours);
		l.info(cours);
		String newParam="git jenkins sonar";
		cours.setDescription(newParam);
		cours.setIntitule("DevOps");
		long aftermodif =coursService.modifierCours(cours,cours.getId());
		Cours updatedCours =coursRepository.findById(aftermodif);
		l.info(updatedCours);
		assertThat(newParam).isEqualTo(updatedCours.getDescription());

	}
	@Test
	void testDeleteCours() {
		Cours cours = newCours();
		coursService.addCours(cours);
		long id=cours.getId();
		assertNotNull(coursRepository.findById(id));
		coursService.supprimerCours(id);
		assertNull(coursRepository.findById(id));

	}

	private Cours newCours() {
		Cours cours = new Cours();
		cours.setDescription("DevOps");
		cours.setIntitule("Spring : Using JUnit");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		return cours;
	}
}
