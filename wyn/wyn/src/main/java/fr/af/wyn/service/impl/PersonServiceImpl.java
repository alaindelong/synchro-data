package fr.af.wyn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.af.wyn.entity.Person;
import fr.af.wyn.entity.Webhook;
import fr.af.wyn.repository.PersonRepository;
import fr.af.wyn.service.PersonService;
import fr.af.wyn.service.WebhookService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private WebhookService webhookService;

	@Override
	public Person createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		//find all webhook with the create event
	    List<Webhook> webhooks = webhookService.findByEventName("create");
		System.out.println("Begin synchronization with crm..");
		for(Webhook webhook:webhooks) {
			webhookService.triggerUpdate(webhook.getId(), savedPerson);
		}
		System.out.println("End synchronization with crm..");
		return savedPerson;
	}

}
