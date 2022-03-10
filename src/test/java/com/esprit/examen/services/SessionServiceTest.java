package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.repositories.SessionRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

	@SpringBootTest
	public class SessionServiceTest {
		@Autowired
		SessionRepository SessionRepository ;
		private static final Logger l =LogManager.getLogger(SessionServiceTest.class);
		@Test
		public void testaddSession() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Session s = new Session();
			Formateur f = new Formateur();
			f.setNom("ali");
			Cours c = new Cours();
			c.setIntitule("cour 1");
			Set<Cours> cf = new HashSet<Cours>();
			
			s.setCours(cf);
			try {
				s.setDateDebut(dateFormat.parse("09/03/2022"));
				s.setDateFin(dateFormat.parse("09/05/2022"));
			} catch (ParseException e) {
				e.printStackTrace();
			}			
			s.setDescription("session 1");
			s.setDuree((long) 2);
			s.setFormateur(f);
			l.info(s);
			
			//before
			long dataBeforeTest = SessionRepository.count();
			
			//saving
		//	List<Session> st = new ArrayList<Session>();
		//	st.add(s);
		//	SessionRepository.saveAll(st);
			
			//after
			long dataAfterTest = SessionRepository.count();
			
			//isEqual
	//		assertThat(dataBeforeTest).isEqualTo(dataAfterTest -1);
		
			
	//		SessionRepository.deleteById(s.getId());
		}
	}