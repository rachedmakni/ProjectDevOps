package com.esprit.examen.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Cours.CoursRequestModel;
import com.esprit.examen.services.ICoursService;

@RestController
public class CoursRestController {
@Autowired
ICoursService coursService;



@PostMapping("/ajouterCours")
@ResponseBody
public Cours ajouterCours(@RequestBody CoursRequestModel coursRequestModel) {
	Cours cours = new Cours(coursRequestModel);
	coursService.addCours(cours);
	return cours;
}

@PutMapping("/modifierCours/{coursId}")
@ResponseBody
public long modifierCours(@RequestBody CoursRequestModel coursRequestModel,@PathVariable("coursId") long coursIdToBeUpdate) {
	Cours cours = new Cours(coursRequestModel);
	coursService.modifierCours(cours, coursIdToBeUpdate);
	return coursIdToBeUpdate;

}

@DeleteMapping("/supprimerCours/{coursId}")
@ResponseBody
public void supprimerCours(@PathVariable("coursId") long coursId) {
	coursService.supprimerCours(coursId);
}

@GetMapping("/listeCours")
@ResponseBody
public List<Cours> listeCours() {
	
	return  coursService.getCours();
}

@PutMapping("/affecterCoursASession/{coursId}/{sessionId}")
@ResponseBody
public String affecterCoursASession(@PathVariable("coursId")  long coursId, @PathVariable("sessionId") long sessionId) {
	coursService.affecterCoursASession(coursId, sessionId);
	return "cours affecté correctement";
}

@PutMapping("/suppCoursASession/{coursId}/{sessionId}")
@ResponseBody
public String suppCoursASession(@PathVariable("coursId")  long coursId, @PathVariable("sessionId") long sessionId) {
	coursService.suppCoursASession(coursId, sessionId);
	return "cours supprimer correctement";
}

}
