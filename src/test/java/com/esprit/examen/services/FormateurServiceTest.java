package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.repositories.FormateurRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootTest
public class FormateurServiceTest {
	@Autowired
	FormateurRepository formateurRepository ;
	private static final Logger l =LogManager.getLogger(CoursServiceTest.class);
	@Test
	public void testAddCours() {

		Formateur f = new Formateur();
		f.setNom("Orabi");
		f.setPrenom("Zied");
		f.setPoste(Poste.Ingénieur);
		l.info(f);
		
		//before
		long dataBeforeTest = formateurRepository.count();
		
		//saving
		formateurRepository.save(f);
		
		//after
		long dataAfterTest = formateurRepository.count();
		
		//isEqual
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
	
		
		formateurRepository.delete(f);
	}
}
