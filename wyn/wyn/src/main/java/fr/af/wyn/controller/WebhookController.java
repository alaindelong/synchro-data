package fr.af.wyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.af.wyn.entity.Webhook;
import fr.af.wyn.service.WebhookService;

@RestController
@RequestMapping("/webhooks")
public class WebhookController {

	@Autowired
	private WebhookService webhookService;
	
	@PostMapping
	public Webhook createWebhook(@RequestBody Webhook webhook) {
		System.out.println("Begin create webhook.");
		Webhook createdWebhook = webhookService.createWebhook(webhook);
		System.out.println("End create webhook with.");
		return createdWebhook;
	}
}
