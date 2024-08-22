package fr.af.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.af.crm.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
