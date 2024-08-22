package fr.af.wyn.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.af.wyn.entity.Person;
import fr.af.wyn.entity.Webhook;

@Service
public class WebhookExecutionService {

	@Autowired
	private RestTemplate restTemplate;
	
	public void executeWebhook(Webhook webhook, Person payload) {
		System.out.println("webhook execution....");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Person> request = new HttpEntity<Person>(payload, headers);
		
		restTemplate.postForObject(webhook.getUrl(), request, Object.class);
	}
}
