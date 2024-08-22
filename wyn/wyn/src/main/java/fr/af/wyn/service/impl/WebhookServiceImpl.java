package fr.af.wyn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.af.wyn.entity.Person;
import fr.af.wyn.entity.Webhook;
import fr.af.wyn.repository.WebhookRespository;
import fr.af.wyn.service.WebhookExecutionService;
import fr.af.wyn.service.WebhookService;

@Service
@Transactional
public class WebhookServiceImpl implements WebhookService {

	@Autowired
	private WebhookRespository webhookRespository;
	@Autowired
	private WebhookExecutionService webhookExecutionService;
	
	@Override
	public Webhook createWebhook(Webhook webhook) {
		Webhook savedWebhook = webhookRespository.save(webhook);
		return savedWebhook;
	}

	@Override
	public List<Webhook> findAll() {
		
		return webhookRespository.findAll();
	}

	@Override
	public List<Webhook> findByEventName(String eventName) {
		
		return webhookRespository.findByEventName(eventName);
	}

	@Override
	public Webhook findByAppID(String appID) {
		
		return webhookRespository.findByAppID(appID);
	}

	@Override
	public Webhook findByUrl(String url) {
		
		return webhookRespository.findByUrl(url);
	}

	@Override
	public Webhook findByID(Integer id) {
		
		Optional<Webhook> webhook = webhookRespository.findById(id);
		if(webhook.isPresent()) {
		  return webhook.get();
		}else {
			return null;
			}
	}

	@Override
	public void triggerUpdate(Integer webhookID, Person payload) {
		Webhook webhook = findByID(webhookID);
		if(webhook != null) {
			webhookExecutionService.executeWebhook(webhook, payload);
		}else {
			//throw an exception
			System.out.println(String.format("webhook with id %d not found...",webhookID));
		}
	}

}
