package com.esprit.examen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.repositories.SessionRepository;

@Service
public class SessionService implements ISessionService{

	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	FormateurRepository formateurRepository;
	@Override
	public Long addSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public Long modifierSession(Session session) {
		sessionRepository.save(session);
		return session.getId();
	}

	@Override
	public void supprimerSession(Long sessionId) {
		sessionRepository.deleteById(sessionId);
	}

	@Override
	public void affecterFormateurASession(Long formateurId, Long sessionId) {
		if (formateurRepository.findById(formateurId).isPresent()){
		Formateur formateur = formateurRepository.findById(formateurId).get();
		Session session = sessionRepository.findById(sessionId).get();
		if (session!= null){
			session.setFormateur(formateur);
			sessionRepository.save(session);
		}
		else{
			throw new RuntimeException("no session with the given Id");
		}
		}
		else {
			throw new RuntimeException("no formateur with the given Id");
		}
	}

}
