package lt.sventes.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.sventes.user.User;

@Service
public class UserService {
	@Autowired
	@Qualifier("repoUserDao")
	private UserDao userDao;

	//SITA NAUDOTI---------
	@Autowired
	private UserRepository userRepository;
	
	//-----naujos tranzakcijos su Spring Data----
	@Transactional
	public List<User> getSpringUsers(){
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
	//-----susikurtos savos transakcijos su Spring Data----
	@Transactional
	public List<User> findUsersByFirstNameAndLastName(String firstName, String lastName){
		return userRepository.findUsersByFirstNameAndLastName(firstName, lastName);
	}
	
	@Transactional
	public List<User> findUsersByFirstNameContainingAndLastNameContaining (String partOfFirstName, String partOfLastName){
		return userRepository.findUsersByFirstNameContainingAndLastNameContaining(partOfFirstName, partOfLastName);
	}
	
	//Seniausio zmogaus paieska
	@Transactional
	public User findOldestUser() {
		return userRepository.findOldestUser();
	}

	//--------senosios transakcijos--------
	@Transactional(readOnly = true)
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Transactional
	public void createUser(User user) {
		userDao.createUser(user);
	}
	
	@Transactional
	public void deleteUser(String username) {
		userDao.deleteUser(username);
	}

}
