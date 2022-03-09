package com.esprit.examen.services;

import java.util.List;
import java.util.Set;

import com.esprit.examen.entities.Cours;

public interface ICoursService {
	Long addCours(Cours cours);

	long modifierCours(long coursId);

	void supprimerCours(Long coursId);
	
	List<Cours> getCours();
	
	void affecterCoursASession(Long coursId, Long sessionId);
}
