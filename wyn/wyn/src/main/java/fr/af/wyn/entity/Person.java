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
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String firstName;
private String lastName;
private String email;
private String phoneNumber;
private String address;
}
