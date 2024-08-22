package fr.af.wyn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.af.wyn.entity.Webhook;
@Repository
public interface WebhookRespository extends JpaRepository<Webhook, Integer> {

	public List<Webhook> findByEventName(String eventName);
	public Webhook findByAppID(String appID);
	public Webhook findByUrl(String url);
}
