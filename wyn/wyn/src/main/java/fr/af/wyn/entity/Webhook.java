package fr.af.wyn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Webhook {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String eventName;
	private String url;
	private String appID;
}
