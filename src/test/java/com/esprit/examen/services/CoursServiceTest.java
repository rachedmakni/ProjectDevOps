package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.CoursRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
 class CoursServiceTest {
	@Autowired
	CoursRepository coursRepository ;
	private static final Logger l =LogManager.getLogger(CoursServiceTest.class);
	@Test
	 void testAddCours() {

		Cours cours = new Cours();
		cours.setDescription("DevOps");
		cours.setIntitule("Spring : Using JUnit");
		cours.setTypeCours(TypeCours.INFORMATIQUE);
		l.info(cours);
		
		//before
		long dataBeforeTest = coursRepository.count();
		
		//saving
		coursRepository.save(cours);
		
		//after
		long dataAfterTest = coursRepository.count();
		
		//isEqual
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
		//assertTrue(dataBeforeTest==dataAfterTest-1);
		
		coursRepository.delete(cours);
	}
}
