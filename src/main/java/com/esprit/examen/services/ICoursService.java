package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.Cours;

public interface ICoursService {
	Long addCours(Cours cours);

	long modifierCours(Cours cours,long coursId);

	void supprimerCours(long coursId);
	
	List<Cours> getCours();
	
	void affecterCoursASession(long coursId, long sessionId);

	void suppCoursASession(long coursId, long sessionId);
}
