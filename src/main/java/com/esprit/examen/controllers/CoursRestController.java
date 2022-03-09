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
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.services.ICoursService;

@RestController
public class CoursRestController {
@Autowired
ICoursService coursService;
@Autowired
CoursRepository clientRep;
@PostMapping("/ajouterCours")
@ResponseBody
public Cours ajouterCours(@RequestBody Cours cours) {
	coursService.addCours(cours);
	return cours;
}

@PutMapping("/modifierCours/{coursId}")
@ResponseBody
public long modifierCours(@PathVariable("coursId") long coursId) {
	coursService.modifierCours(coursId);
	return coursId;

}

@DeleteMapping("/supprimerCours/{coursId}")
@ResponseBody
public void supprimerCours(@PathVariable("coursId") Long coursId) {
	coursService.supprimerCours(coursId);
}

@GetMapping("/listeCours")
@ResponseBody
public List<Cours> listeCours() {
	
	return  coursService.getCours();
}

@PutMapping("/affecterCoursASession/{coursId}/{sessionId}")
@ResponseBody
public String affecterCoursASession(@PathVariable("coursId")  Long coursId, @PathVariable("sessionId") Long sessionId) {
	coursService.affecterCoursASession(coursId, sessionId);
	return "cours affecté correctement";
}

@PutMapping("/suppCoursASession/{coursId}/{sessionId}")
@ResponseBody
public String suppCoursASession(@PathVariable("coursId")  Long coursId, @PathVariable("sessionId") Long sessionId) {
	coursService.suppCoursASession(coursId, sessionId);
	return "cours supprimer correctement";
}

}
