package fr.af.wyn.service;

import java.util.List;

import fr.af.wyn.entity.Person;
import fr.af.wyn.entity.Webhook;

public interface WebhookService {

	public Webhook createWebhook(Webhook webhook);
	public List<Webhook> findAll();
	public List<Webhook> findByEventName(String eventName);
	public Webhook findByAppID(String appID);
	public Webhook findByUrl(String url);
	public Webhook findByID(Integer id);
	public void triggerUpdate(Integer webhookID, Person payload);
}
