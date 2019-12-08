package it.akademija.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.akademija.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findUsersByFirstNameAndLastName(String firstName, String lastName);
	List<User> findUsersByFirstNameContainingAndLastNameContaining (String partOfFirstName, String partOfLastName);
} 
