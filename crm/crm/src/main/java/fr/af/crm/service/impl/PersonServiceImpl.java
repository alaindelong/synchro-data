package fr.af.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.af.crm.entity.Person;
import fr.af.crm.repository.PersonRepository;
import fr.af.crm.service.PersonService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

}
