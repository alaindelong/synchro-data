package fr.af.wyn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.af.wyn.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
