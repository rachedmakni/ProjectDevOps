package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	
	@Override
	public Long addCours(Cours cours) {
		coursRepository.save(cours);
		return cours.getId();
	}

	@Override
	public long modifierCours(long coursId) {
		Cours cours= coursRepository.findById(coursId);
		coursRepository.save(cours);
		return coursId;
		}

	@Override
	public void supprimerCours(Long coursId) {
		coursRepository.deleteById(coursId);
		
	}

	@Override
	public List<Cours> getCours() {
		return coursRepository.findAll();
	}
	
	@Override
	public void affecterCoursASession(Long coursId, Long sessionId)
	{
		
	}

}
