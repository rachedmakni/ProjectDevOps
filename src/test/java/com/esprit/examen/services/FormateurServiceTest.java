package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.repositories.FormateurRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//CRUD TESTs

@SpringBootTest
class FormateurServiceTest {
	@Autowired
	IFormateurService formateurService;
	@Autowired
	FormateurRepository formateurRepository;
	private static final Logger l = LogManager.getLogger(FormateurServiceTest.class);


	
	@Test
	void testAddFormateur() {
		Formateur f = new Formateur();
		long dataBeforeTest = formateurRepository.count();
		l.info("before " + dataBeforeTest);
		formateurService.addFormateur(f);
		l.info(f);
		l.debug("saving");
		long dataAfterTest = formateurRepository.count();
		l.info("after " + dataAfterTest);
		// isEqual
		assertThat(dataBeforeTest).isEqualTo(dataAfterTest - 1);
		// assertTrue(dataBeforeTest==dataAfterTest-1);
		formateurService.supprimerFormateur(f.getId());
	}

	@Test
	void testUpdateFormateurName() {
		Formateur f = nouveauFormateur();
		formateurService.addFormateur(f);
		l.info(f);
		String newParam="Wiem";
		f.setNom(newParam);
			long aftermodif =formateurService.modifierFormateur(f);
		Formateur updatedFormateur = formateurRepository.findById(aftermodif);
		l.info("update formateur name " + updatedFormateur.getNom());		
		assertThat(newParam).isEqualTo(updatedFormateur.getNom());

	}
	@Test
	void testDeleteFormateur() {
		Formateur f = nouveauFormateur();
		formateurService.addFormateur(f);
		long id=f.getId();
		assertNotNull(formateurRepository.findById(id));
		formateurService.supprimerFormateur(id);
		assertNull(formateurRepository.findById(id));

	}

	private Formateur nouveauFormateur() {
		Formateur f = new Formateur();
		f.setNom("Cheour");
		f.setPrenom("Zayneb");
		f.setPoste(Poste.INGENIEUR);
		l.info(f);
		return f;
	}
}