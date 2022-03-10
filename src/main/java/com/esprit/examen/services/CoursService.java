package com.esprit.examen.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class CoursService implements ICoursService {

	@Autowired
	CoursRepository coursRepository;
	@Autowired
	SessionRepository sessionRepo;
	
	private static final Logger l =LogManager.getLogger(CoursService.class);
	
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public long modifierCours(Cours cours,long coursIdToBeUpdate) {
		cours.setId(coursIdToBeUpdate);
		coursRepository.save(cours);
		return coursIdToBeUpdate;
		}

	@Override
	public void supprimerCours(long coursId) {
		coursRepository.deleteById(coursId);
		
	}

	@Override
	public List<Cours> getCours() {
		return coursRepository.findAll();
	}
	
	@Override
	public void affecterCoursASession(long coursId, long sessionId)
	{
			if(coursRepository.findById(coursId)!=null) {
				
		    	if(sessionRepo.findById(sessionId)!=null) {
		    	Cours c=coursRepository.findById(coursId);
		    	Session s=sessionRepo.findById(sessionId);
		    	c.getSessions().add(s);
		    	coursRepository.save(c);
		    	}
		    	l.info("cant find Session with such id");
			}
				l.info("cant find Cours with such id");

        
	}
	
	@Override
	public void suppCoursASession(long coursId, long sessionId)
	{
			if(coursRepository.findById(coursId)!=null) {
				
		    	if(sessionRepo.findById(sessionId)!=null) {
		    	Cours c=coursRepository.findById(coursId);
		    	Session s=sessionRepo.findById(sessionId);
		    	c.getSessions().remove(s);
		    	coursRepository.save(c);
		    	}
		    	l.info("cant find Session with such id");
			}
				l.info("cant find Cours with such id");

        
	}

}
