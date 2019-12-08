package it.akademija.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.akademija.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//-----naujos tranzakcijos su Spring Data----
	@Transactional(readOnly = true)
	public List<User> getSpingUsers(){
		System.out.println("Spausdinu iš Spring Data metodo");
		System.out.println(userRepository.findAll());
		return userRepository.findAll();
	}
	
	@Transactional
	public void createSpringUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public void deleteSpringUser(String username) {
		userRepository.delete(new User (username, "", "", "", 0));
	}
	
	@Transactional(readOnly = true)
	public List<User> findUsersByFirstNameAndLastName(String firstName, String lastName){
		return userRepository.findUsersByFirstNameAndLastName(firstName, lastName);
	}
	
	@Transactional(readOnly = true)
	public List<User> findUsersByFirstNameContainingAndLastNameContaining (String partOfFirstName, String partOfLastName){
		return userRepository.findUsersByFirstNameContainingAndLastNameContaining(partOfFirstName, partOfLastName);
	}
	
	//Seniausio zmogaus paieska
	@Transactional
	public User findOldestUser() {
		return userRepository.findOldestUser();
	}

}
