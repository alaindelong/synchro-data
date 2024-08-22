package fr.af.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.af.crm.entity.Person;
import fr.af.crm.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@PostMapping
	public Person createPerson (@RequestBody Person person) {
		System.out.println("Begin create person.");
		Person createdPerson = personService.createPerson(person);
		System.out.println("End create person.");
		return createdPerson;
	}
}
