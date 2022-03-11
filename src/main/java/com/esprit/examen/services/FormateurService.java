package com.esprit.examen.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

@Service
public class FormateurService implements IFormateurService{
	private static final Logger l = LogManager.getLogger(FormateurService.class);
	
	@Autowired
	FormateurRepository formateurRepository;
	@Override
	public Long addFormateur(Formateur formateur) {
		
		
		
		try {
			l.info("ajouter formateur ");
			l.debug("je vais ajouter un formateur");
			formateurRepository.save(formateur);

			l.debug("je viens d'ajouter un formateur");
			l.info("formateur ajouté sans erreur");
			
			
		}
		 catch (Exception e) {l.info("formateur existe déjà");}
		
		return formateur.getId();
	}

	@Override
	public Long modifierFormateur(Formateur formateur) {
		
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		formateurRepository.deleteById(formateurId);
		
	}

	@Override
	public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
		return formateurRepository.nombreFormateursImpliquesDansUnCours(typeCours);
	}



	@Override
	public List<Formateur> listFormateurs() {
		
		return formateurRepository.findAll();
	}

}