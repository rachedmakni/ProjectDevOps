package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.Cours;

public interface ICoursService {
	Long addCours(Cours cours);

	long modifierCours(long coursId);

	void supprimerCours(Long coursId);
	
	List<Cours> getCours();
	
	void affecterCoursASession(long coursId, long sessionId);

	void suppCoursASession(long coursId, long sessionId);
}
